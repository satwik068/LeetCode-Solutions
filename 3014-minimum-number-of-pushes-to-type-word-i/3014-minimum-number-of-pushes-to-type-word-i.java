class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int count = 0;
        if(n<=8){
            count = n;
        }
        else{
            count = 8;
            n -= 8;
            if(n<=8){
                count += n*2;
            }
            else{
                count += 8*2;
                n -= 8;
                if(n<=8){
                    count += n*3;
                }
                else{
                    count += 8*3;
                    n -= 8;
                    if(n!=0){
                        count += n*4;
                    }
                }
            }

        }
        return count;
    }
}