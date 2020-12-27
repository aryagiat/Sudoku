class SudokuSolver{
    public static Sudoku grid = new Sudoku();

    public static void main(String[] args){
        if (solve(0, 0)){
            grid.displayBoard();
        } else {
            System.out.println("No Solution");
        }
    }

    public static boolean solve(int row, int col){
        if (row == 8 && col == 9)
            return true;

        if (col == 9){
            ++row;
            col = 0;
        }


        if (grid.board[row][col] != 0)
           return solve(row, col + 1);

        for (int num = 1; num < 10; ++num){
            if (isValid(num, row, col)){
        //System.out.println("Row: " + row + " Col: " + col + "Num : " + num);
                grid.board[row][col] = num;

                if (solve(row, col + 1))
                    return true;
            }

            grid.board[row][col] = 0;
        }
        return false;
    }

    public static boolean isValid(int num, int row, int col){
        // check whether inputting num to row and col is valid
        // Check row
        for (int c = 0; c < 9; ++c){
            if (grid.board[row][c] == num && col != c)
                return false;
        }

        // Check col
        for (int r = 0; r < 9; ++r){
            if (grid.board[r][col] == num && row != r)
                return false;
        }

        // Check 3x3 box
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int r = 0; r < 3; ++r){
            for (int c = 0; c < 3; ++c){
                if (grid.board[r + startRow][c + startCol] == num)
                    return false;
            }
        }

        return true;
    }
}
