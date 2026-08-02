class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if("({[".indexOf(ch)!=-1){
                stack.push(s.charAt(i));
            }
            else if(stack.isEmpty()) return false;
            else{
                if(ch==')'&& stack.pop()!='('){
                    return false;
                }
                if(ch=='}'&& stack.pop()!='{'){
                    return false;
                }
                if(ch==']'&& stack.pop()!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}