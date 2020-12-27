class Sudoku {
    // The board data structure is a 2D array
    private static int[][] board = 
                {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                 {6, 0, 0, 1, 9, 5, 0, 0, 0},
                 {0, 9, 8, 0, 0, 0, 0, 6, 0},
                 {8, 0, 0, 0, 6, 0, 0, 0, 3},
                 {4, 0, 0, 8, 0, 3, 0, 0, 1},
                 {7, 0, 0, 0, 2, 0, 0, 0, 6},
                 {0, 6, 0, 0, 0, 0, 2, 8, 0},
                 {0, 0, 0, 4, 1, 9, 0, 0, 5},
                 {0, 0, 0, 0, 8, 0, 0, 7, 9}};
    
    public static void main(String[] args){
        displayBoard();
        System.out.println("Row: " + checkRow());
        System.out.println("Col: " + checkCol());
    }

    public static boolean checkCol(){
        // Checking validity of all columns
        // Check validity using an array
        for (int c = 0; c < 9; ++c){
            int [] check = new int[10];
            for (int r = 0; r < 9; ++r){
                int num = board[r][c];
                //System.out.println("R: " + r + "  C: " + c + " Num: " + num + "  Check: " + check[num]);
                if (num > 0 && check[num] > 0){
                    return false;
                } else {
                    check[num] = check[num] + 1;
                }
            }
        }
        return true;
    }


    public static boolean checkRow(){
        // Checking validity of all rows
        // Check validity using an array
        for (int r = 0; r < 9; ++r){
            int [] check = new int[10];
            for (int c = 0; c < 9; ++c){
                int num = board[r][c];
                //System.out.println("R: " + r + "  C: " + c + " Num: " + num + "  Check: " + check[num]);
                if (num > 0 && check[num] > 0){
                    return false;
                } else {
                    check[num] = check[num] + 1;
                }
            }
        }
        return true;
    }

    public static void displayBoard(){
        // Display the board.
        for (int r  = 0; r < 9; ++r){
            if (r % 3 == 0){
                System.out.println("-------------------------");
            }
            for (int c = 0; c < 9; ++c){
                if (c % 3 == 0){
                    System.out.print("| ");
                }
                System.out.print(board[r][c] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("-------------------------");
    }
}
