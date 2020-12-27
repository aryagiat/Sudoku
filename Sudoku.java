class Sudoku {
    // The board data structure is a 2D array
    // Incomplete board
    public static int[][] board = 
                {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                 {6, 0, 0, 1, 9, 5, 0, 0, 0},
                 {0, 9, 8, 0, 0, 0, 0, 6, 0},
                 {8, 0, 0, 0, 6, 0, 0, 0, 3},
                 {4, 0, 0, 8, 0, 3, 0, 0, 1},
                 {7, 0, 0, 0, 2, 0, 0, 0, 6},
                 {0, 6, 0, 0, 0, 0, 2, 8, 0},
                 {0, 0, 0, 4, 1, 9, 0, 0, 5},
                 {0, 0, 0, 0, 8, 0, 0, 7, 9}};
/*
    // Completed board
    public static int[][] board =
                {{5, 3, 4, 6, 7, 8, 9, 1, 2},
                 {6, 7, 2, 1, 9, 5, 3, 4, 8},
                 {1, 9, 8, 3, 4, 2, 5, 6, 7},
                 {8, 5, 9, 7, 6, 1, 4, 2, 3},
                 {4, 2, 6, 8, 5, 3, 7, 9, 1},
                 {7, 1, 3, 9, 2, 4, 8, 5, 6},
                 {9, 6, 1, 5, 3, 7, 2, 8, 4},
                 {2, 8, 7, 4, 1, 9, 6, 3, 5},
                 {3, 4, 5, 2, 8, 6, 1, 7, 9}};
*/    

    public static void main(String[] args){
        displayBoard();
        System.out.println("Row: " + checkAllRow());
        System.out.println("Col: " + checkAllCol());
        System.out.println("3x3: " + checkAll3X3());
        System.out.println("Don: " + isDone());
    }

    public static boolean isDone(){
        // Checking whether the board is completed
        for (int r = 0; r < 9; ++r){
            for (int c = 0; c < 9; ++c){
                if (board[r][c] == 0){
                    return false;
                }
            }
        }
        return checkAllRow() && checkAllCol() && checkAll3X3();
    }

    public static boolean checkAll3X3(){
        // Checking validity of all 3x3 boxes
        for (int box = 0; box < 9; ++box){
            int [] check = new int[10];
            int sr = box < 3 ? 0 : box < 6 ? 3 : 6;
            int sc = (box % 3) * 3;
            for (int r = 0; r < 3; ++r){
                for (int c = 0; c < 3; ++c){
                    int num = board[r + sr][c + sc];
                    if (num > 0 && check[num] > 0){
                        return false;
                    } else {
                        check[num] = check[num] + 1;
                    }
                }
            }
        }
        return true;
    }
                    

    public static boolean checkAllCol(){
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


    public static boolean checkAllRow(){
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
