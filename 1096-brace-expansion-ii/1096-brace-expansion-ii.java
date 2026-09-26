import java.util.*;

class Solution {
    int idx = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    // Parse union expressions
    private Set<String> parse(String s) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (idx < s.length() && s.charAt(idx) != '}') {
            char c = s.charAt(idx);

            if (c == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                idx++;
            } else {
                Set<String> part;

                if (c == '{') {
                    idx++;
                    part = parse(s);
                    idx++; // skip '}'
                } else {
                    part = new HashSet<>();
                    part.add(String.valueOf(c));
                    idx++;
                }

                current = multiply(current, part);
            }
        }

        result.addAll(current);
        return result;
    }

    // Cartesian product for concatenation
    private Set<String> multiply(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}