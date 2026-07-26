class Solution {
    public List<String> letterCombinations(String digits) {
        return keypad("", digits);
    }
    public List<String> keypad(String p, String digits) {
        if(digits.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = digits.charAt(0)-'0';
        List<String> ans = new ArrayList<>();
        if(digit==7){
            for(int i=(digit-1)*3; i<digit*3+1; i++){
                char ch = (char)('a'+(i-3));
                ans.addAll(keypad(p+ch, digits.substring(1)));
            }   
        }
        else if(digit==8){
            for(int i=(digit-1)*3; i<digit*3; i++){
                char ch = (char)('a'+(i-2));
                ans.addAll(keypad(p+ch, digits.substring(1)));
            }
        }
        else if(digit==9){
            for(int i=(digit-1)*3; i<digit*3+1; i++){
                char ch = (char)('a'+(i-2));
                ans.addAll(keypad(p+ch, digits.substring(1)));
            }
        }
        else{
            for(int i=(digit-1)*3; i<digit*3; i++){
                char ch = (char)('a'+(i-3));
                ans.addAll(keypad(p+ch, digits.substring(1)));
            }
        }
        return ans;
    }



}