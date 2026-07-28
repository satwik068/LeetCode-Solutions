class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n==1) return s;

        char[] a = s.substring(0, n/2).toCharArray();
        Arrays.sort(a);
        StringBuilder ans = new StringBuilder();
        ans.append(a);
        
        String answer = ans.toString();
        if(n%2==0){
            answer += ans.reverse().toString();
        }
        else{
            answer += s.charAt(n/2) + ans.reverse().toString();
        }
        return answer;

    }
}