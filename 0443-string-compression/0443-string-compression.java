class Solution {
    public int compress(char[] chars) {
        String s = "";
        int count =1;
        for(int i=0; i<chars.length; i++){
            if(i<chars.length-1 && chars[i]==chars[i+1]){
                count++;
            }
            else{
                s += chars[i];
                if(count>1) s+=count;
                count=1;
            }
        }

        for(int i=0; i<s.length(); i++){
            chars[i] = s.charAt(i);
        }
        return s.length();

    }
}