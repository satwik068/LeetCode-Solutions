class Solution {
    public int lcs(int i, int j, StringBuilder a, StringBuilder b, int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j] =  1 + lcs (i-1, j-1, a, b, dp);
        }
        else{
            return dp[i][j] =  Math.max(lcs(i, j-1, a, b, dp), lcs(i-1, j, a, b, dp));
        }
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder s1 = new StringBuilder(word1);
        StringBuilder s2 = new StringBuilder(word2);
        int[][] dp = new int[m][n];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }
        int c = lcs(m-1, n-1, s1, s2, dp);
        int num1 = m-c;
        int num2 = n-c;
        return num1+num2;
    }
}