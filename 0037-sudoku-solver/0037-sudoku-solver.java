class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    static boolean solve(char[][] board){
        int n = board.length;
        int r = -1;
        int c = -1;

        boolean isEmpty = true;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='.'){
                    r = i;
                    c = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty){
                break;
            }
        }

        if(isEmpty){
            return true;
        }

        for(int num=1; num<=9; num++){
            if(isSafe(board, r, c, num)){
                board[r][c] = (char)(num+'0');
                if(solve(board)){
                    return true;
                }
                else{
                    board[r][c] = '.';
                }
            }
        }
        return false;
    }

    static boolean isSafe(char[][] board, int row, int col, int num){
        for(int i=0; i<board.length; i++){
            if(board[row][i]-'0'==num){
                return false;
            }
        }
        for(char[] ch:board){
            if(ch[col]-'0'==num){
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(board.length);
        int srow = row - row%sqrt;
        int scol = col - col%sqrt;

        for(int i=srow; i<srow+sqrt; i++){
            for(int j=scol; j<scol+sqrt; j++){
                if(board[i][j]-'0'==num){
                    return false;
                }
            }
        }
        return true;
    }
}