class Solution {
    public int minimumPushes(String word) {
        int[] a = new int[26];
        for(int i=0; i<word.length(); i++){
            a[word.charAt(i)-'a']++;
        }
        Arrays.sort(a);
        int count = 0;
        int i=25;
        while(i!=-1 && a[i]!=0){
            if(i>17){
                count += a[i];
            }
            else if(i>9){
                count += a[i]*2;
            }
            else if(i>1){
                count += a[i]*3;
            }
            else{
                count += a[i]*4;
            }
            i--;
        }
        return count;
    }
}