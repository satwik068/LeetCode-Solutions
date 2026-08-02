class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    count++;
                }
                else{
                    char top = st.pop();

                    if (ch == ')' && top != '('){
                        count++;
                    }

                }
            }
        }

        return count+st.size();
    }
}