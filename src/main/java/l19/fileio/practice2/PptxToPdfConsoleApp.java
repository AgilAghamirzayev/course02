package l19.fileio.practice2;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class PptxToPdfConsoleApp {

    private static final float RENDER_SCALE = 2.0f;

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            printUsage();
            return;
        }

        Path inputPath = Path.of(args[0]);
        Path outputPath = args.length == 2 ? Path.of(args[1]) : defaultOutputPath(inputPath);

        if (!Files.exists(inputPath) || !Files.isRegularFile(inputPath)) {
            System.err.println("Input file not found: " + inputPath.toAbsolutePath());
            return;
        }
        if (!inputPath.getFileName().toString().toLowerCase().endsWith(".pptx")) {
            System.err.println("Input file must be a .pptx file.");
            return;
        }

        try {
            createParentDirectoryIfNeeded(outputPath);
            convertPptxToPdf(inputPath, outputPath);
            System.out.println("Done. PDF created: " + outputPath.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Conversion failed: " + e.getMessage());
        }
    }

    private static void convertPptxToPdf(Path inputPath, Path outputPath) throws IOException {
        try (InputStream in = Files.newInputStream(inputPath);
             XMLSlideShow slideShow = new XMLSlideShow(in);
             PDDocument pdf = new PDDocument()) {

            Dimension pageSize = slideShow.getPageSize();
            float pageWidth = (float) pageSize.getWidth() * RENDER_SCALE;
            float pageHeight = (float) pageSize.getHeight() * RENDER_SCALE;
            PDRectangle pdfPageSize = new PDRectangle(pageWidth, pageHeight);

            for (XSLFSlide slide : slideShow.getSlides()) {
                BufferedImage image = renderSlide(slide, pageSize, RENDER_SCALE);
                PDPage page = new PDPage(pdfPageSize);
                pdf.addPage(page);

                PDImageXObject pdImage = LosslessFactory.createFromImage(pdf, image);
                try (PDPageContentStream content = new PDPageContentStream(pdf, page)) {
                    content.drawImage(pdImage, 0, 0, pageWidth, pageHeight);
                }
            }

            pdf.save(outputPath.toFile());
        }
    }

    private static BufferedImage renderSlide(XSLFSlide slide, Dimension pageSize, float scale) {
        int width = Math.max(1, Math.round((float) pageSize.getWidth() * scale));
        int height = Math.max(1, Math.round((float) pageSize.getHeight() * scale));
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = image.createGraphics();
        try {
            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setPaint(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.scale(scale, scale);
            slide.draw(graphics);
        } finally {
            graphics.dispose();
        }

        return image;
    }

    private static Path defaultOutputPath(Path inputPath) {
        String fileName = inputPath.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        String baseName = dotIndex > 0 ? fileName.substring(0, dotIndex) : fileName;
        return inputPath.resolveSibling(baseName + ".pdf");
    }

    private static void createParentDirectoryIfNeeded(Path outputPath) throws IOException {
        Path parent = outputPath.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  java l19.fileio.practice2.PptxToPdfConsoleApp <input.pptx> [output.pdf]");
    }
}
