class Solution {
    public int reverseDegree(String s) {
        char[] ch = s.toCharArray();
        int sum = 0;
        for(int i=0; i<ch.length; i++){
            sum += (i+1)*(ch[i]-'a'- 26)*-1;
        }
        return sum;
    }
}