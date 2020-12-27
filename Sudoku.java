class Sudoku {
    private static int[][] board = new int[9][9]; 
    
    public static void main(String[] args){
        displayBoard();
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
