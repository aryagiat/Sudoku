class SudokuSolver{
    public static Sudoku grid = new Sudoku();

    public static void main(String[] args){
        int[] find = findEmpty();
        if (find[0] == 9 && find[1] == 9)
            grid.displayBoard();

    }

    public static int[] findEmpty(){
        int[] coord = {9, 9};
        for (int r = 0; r < 9; ++r){
            for (int c = 0; c < 9; ++c){
                if (grid.board[r][c] == 0){
                    coord[0] = r;
                    coord[1] = c;
                    return coord;
                }
            }
        }
        return coord;
    }
}
