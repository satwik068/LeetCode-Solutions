class Solution {

    class Node {
        char leftChar, rightChar;
        int prefix, suffix, best, len;

        Node(char lc, char rc, int p, int s, int b, int l) {
            leftChar = lc;
            rightChar = rc;
            prefix = p;
            suffix = s;
            best = b;
            len = l;
        }
    }

    Node[] tree;
    String s;

    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node res = new Node(
            a.leftChar,
            b.rightChar,
            0, 0, 0,
            a.len + b.len
        );

        res.prefix = a.prefix;
        if (a.prefix == a.len && a.rightChar == b.leftChar)
            res.prefix = a.len + b.prefix;

        res.suffix = b.suffix;
        if (b.suffix == b.len && a.rightChar == b.leftChar)
            res.suffix = b.len + a.suffix;

        res.best = Math.max(a.best, b.best);

        if (a.rightChar == b.leftChar)
            res.best = Math.max(res.best, a.suffix + b.prefix);

        return res;
    }

    void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(s.charAt(l), s.charAt(l),
                    1, 1, 1, 1);
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int pos, char c) {
        if (l == r) {
            tree[node] = new Node(c, c, 1, 1, 1, 1);
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid)
            update(node * 2, l, mid, pos, c);
        else
            update(node * 2 + 1, mid + 1, r, pos, c);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    public int[] longestRepeating(String s,
                                   String queryCharacters,
                                   int[] queryIndices) {

        this.s = s;
        int n = s.length();

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, c);

            ans[i] = tree[1].best;
        }

        return ans;
    }
}