class BoardPrinter {

    static void print(Tile[][] board) {
        System.out.println("      [A] [B] [C] [D] [E] [F] [G] [H]  ");
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



