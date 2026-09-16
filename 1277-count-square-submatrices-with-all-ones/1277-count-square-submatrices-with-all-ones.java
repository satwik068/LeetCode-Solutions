class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0) count += matrix[i][j];
                else if(matrix[i][j]==1){
                    int min1 = Math.min(matrix[i][j-1], matrix[i-1][j]);
                    int min = Math.min(min1, matrix[i-1][j-1]);
                    matrix[i][j] += min;
                    count += matrix[i][j];
                }
            }
        }
        return count;
    }
}