package Engine;

public class BoardPrinter {

    public static void print(Tile[][] board) {
        System.out.println("      [1] [2] [3] [4] [5] [6] [7] [8]  ");
        System.out.println("    +---------------------------------+");
        for (int y = 7; y >= 0; y--) {
            System.out.print("[" + (y + 1) + "]" + " | ");
            for (int x = 0; x < 8; x++) {
                System.out.print(board[y][x].toString() + " ");
            }
            System.out.println("|");

        }
        System.out.println("    +---------------------------------+");
    }
}



