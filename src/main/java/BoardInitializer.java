final class BoardInitializer {


    static void initializeBoard(Tile[][] board) {
        initializeBlackPieces(board);
        initializeWhitePieces(board);
        initializeVacantMiddle(board);
    }

    private static void initializeVacantMiddle(Tile[][] board) {
        for (int y = 3; y < 5; y++) {
            for (int x = 0; x < 8; x++) {
                board[y][x] = new VacantTile(x, y);
            }
        }
    }

    private static void initializeWhitePieces(Tile[][] board) {
        for (int y = 5; y < 8; y++) {
            initializePieces(board, y, Color.BLACK);
        }
    }

    private static void initializeBlackPieces(Tile[][] board) {
        for (int y = 0; y < 3; y++) {
            initializePieces(board, y, Color.WHITE);
        }
    }

    private static void initializePieces(Tile[][] board, int y, Color color) {
        // In even y
        if (y % 2 == 1) {
            for (int x = 0; x < 8; x++) {
                // In even x and even y OccupiedTile
                if (x % 2 == 1) {
                    board[y][x] = new OccupiedTile(x, y, new PlainPiece(color));
                } else {
                // In uneven x and even y fill VacantTile
                    board[y][x] = new VacantTile(x, y);
                }
            }
        } else {
        // In uneven y
            for (int x = 0; x < 8; x++) {
                // In uneven x and uneven y fill OccupiedTile
                if (x % 2 == 0) {
                    board[y][x] = new OccupiedTile(x, y, new PlainPiece(color));
                } else {
                    // In even x and uneven y fill VacantTile
                    board[y][x] = new VacantTile(x, y);
                }
            }
        }
    }
}
