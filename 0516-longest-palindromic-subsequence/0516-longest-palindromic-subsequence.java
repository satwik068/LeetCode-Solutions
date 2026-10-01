
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
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder(s).reverse();
        int[][] dp = new int[m][m];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }
        return lcs(m-1, m-1, s1, s2, dp);
    }
}