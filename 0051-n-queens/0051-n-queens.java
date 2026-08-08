class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        queens(ans, board, 0);
        return ans;
    }
    public void queens(List<List<String>> ans, boolean[][] board, int row){
        if(row==board.length){
            List<String> list = new ArrayList<>();
            display(list, board);
            ans.add(list);
            return;
        }

        for(int col=0; col<board[0].length; col++){
            if(possible(board, row, col)){
                board[row][col] = true;
                queens(ans, board, row+1);
                board[row][col] = false;
            }
        }

    }
    public boolean possible(boolean[][] board, int row, int col){
        for(int i=0; i<row; i++){
            if(board[i][col]) return false;
        }
        int lmin = Math.min(row, col);
        for(int i=1; i<=lmin; i++){
            if(board[row-i][col-i]) return false;
        }
        int rmin = Math.min(row, board.length-col-1);
        for(int i=1; i<=rmin; i++){
            if(board[row-i][col+i]) return false;
        }
        return true;
    }
    public void display(List<String> list, boolean[][] board){
        for(boolean[] arr:board){
            String s = "";
            for(boolean element:arr){
                if(element) s = s+ "Q";
                else s = s+ ".";
            }
            list.add(s);
        }
    }
}