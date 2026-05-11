package l19.fileio;

import java.io.*;

public class FlushDeneme {
    public static void main(String[] args) {
        try {
            // Buffer kullanan bir akış açıyoruz
            FileOutputStream fos = new FileOutputStream("test.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            String mesaj = "Bu veri buffer'da bekliyor!";
            bos.write(mesaj.getBytes());

            // DİKKAT: Burada flush() ÇAĞIRMIYORUZ!
            // bos.flush(); 

            System.out.println("Veri yazıldı (sanılıyor)...");
            
            // Programı burada kasıtlı olarak bekletiyoruz.
            // Bu sırada gidip 'test.txt' dosyasını açarsan içinin BOŞ olduğunu göreceksin.
            System.out.println("Şu an test.txt dosyasını açıp kontrol et, içi boş olacak.");
            Thread.sleep(15000); // 15 saniye bekleme

            // Akış kapandığında Java otomatik flush yapar, 
            // ama o ana kadar dosya diskte boş görünür.
            bos.close();
            System.out.println("Akış kapandı, şimdi dosya doldu.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}