class Solution {

    void reverse(char[] a, int s, int e) {
        while (s < e) {
            char temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        int n = a.length;

        for (int i = 0; i < n; i += 2 * k) {
            reverse(a, i, Math.min(i + k - 1, n - 1));
        }

        return new String(a);
    }
}