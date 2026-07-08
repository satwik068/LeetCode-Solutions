class Solution {
    public String reverseWords(String s) {
        String[] a = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        for(int i=a.length-1; i>=0; i--){
            ans.append(a[i]).append(" ");
        }

        return ans.reverse().toString().trim();
    }
}