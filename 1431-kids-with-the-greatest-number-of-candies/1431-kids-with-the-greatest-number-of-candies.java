class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            boolean check = true;
            int sum = candies[i]+extraCandies;
            for(int j=0; j<n; j++){
                if(sum<candies[j]){
                    check = false;
                    break;
                }
            }
            result.add(check);
        }
        return result;
    }
}