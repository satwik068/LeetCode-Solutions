class Solution {

    public int sum(int n){
        int sum = 0;
        while(n>0){
            int rem = n%10;;
            sum += rem*rem;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do{
            slow = sum(slow);
            fast = sum(sum(fast));
        }while(fast!=slow);
        
        return slow==1;
    }
}