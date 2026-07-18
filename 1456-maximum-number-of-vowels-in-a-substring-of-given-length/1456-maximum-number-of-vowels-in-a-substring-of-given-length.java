class Solution {
    public int maxVowels(String s, int k) {
        String v = "aeiou";
        int count = 0;
        for(int i=0; i<k; i++){
            if(v.indexOf(s.charAt(i))!=-1){
                count++;
            }
        }
        int max = count;

        for(int i=k; i<s.length(); i++){
            if(v.indexOf(s.charAt(i-k))!=-1){
                count--;
            }
            if(v.indexOf(s.charAt(i))!=-1){
                count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}