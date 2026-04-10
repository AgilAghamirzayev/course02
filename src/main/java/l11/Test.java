package l11;

import java.util.Scanner;

public class Test {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Connect-4 ===");
            System.out.print("Enter Player 1 name (" + colorLabel(DiscColor.RED) + "): ");
            String player1Name = scanner.nextLine().trim();
            if (player1Name.isEmpty()) {
                player1Name = "Player1";
            }

            System.out.print("Enter Player 2 name (" + colorLabel(DiscColor.YELLOW) + "): ");
            String player2Name = scanner.nextLine().trim();
            if (player2Name.isEmpty()) {
                player2Name = "Player2";
            }

            Player player1 = new Player(player1Name, DiscColor.RED);
            Player player2 = new Player(player2Name, DiscColor.YELLOW);
            Game game = new Game(player1, player2);

            while (game.getGameState() == GameState.IN_PROGRESS) {
                printBoard(game.getBoard());
                Player current = game.getCurrentPlayer();
                int column = readColumn(scanner, game, current);
                game.makeMove(current, column);
            }

            printBoard(game.getBoard());
            if (game.getGameState() == GameState.WON) {
                System.out.println("Winner: " + game.getWinner().getName() + " (" + colorLabel(game.getWinner().getColor()) + ")");
            } else {
                System.out.println("Game finished with draw");
            }
        }
    }

    private static int readColumn(Scanner scanner, Game game, Player current) {
        Board board = game.getBoard();
        int maxColumn = board.getCols() - 1;

        while (true) {
            System.out.print(current.getName() + " (" + colorLabel(current.getColor()) + "), choose column [0-" + maxColumn + "]: ");
            String input = scanner.nextLine().trim();

            int column;
            try {
                column = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }

            if (column < 0 || column > maxColumn) {
                System.out.println("Column must be between 0 and " + maxColumn + ".");
                continue;
            }

            if (board.canPlace(column)) {
                System.out.println("That column is full. Choose another one.");
                continue;
            }

            return column;
        }
    }

    private static void printBoard(Board board) {
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                DiscColor cell = board.getCell(r, c);
                System.out.print(discSymbol(cell) + " ");
            }
            System.out.println();
        }

        for (int c = 0; c < board.getCols(); c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println();
    }

    private static String discSymbol(DiscColor color) {
        if (color == DiscColor.RED) {
            return RED + "O" + RESET;
        }
        if (color == DiscColor.YELLOW) {
            return YELLOW + "O" + RESET;
        }
        return ".";
    }

    private static String colorLabel(DiscColor color) {
        if (color == DiscColor.RED) {
            return RED + "RED" + RESET;
        }
        if (color == DiscColor.YELLOW) {
            return YELLOW + "YELLOW" + RESET;
        }
        return "UNKNOWN";
    }
}
