/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        ListNode temp = head;
        int top = 0;
        int right = n-1;
        int left = 0;
        int bottom = m-1;

        for(int i=0; i<m; i++){
            Arrays.fill(mat[i], -1);
        }


        while(top<=bottom){
            for(int i=left; i<=right && temp!=null; i++){
                mat[top][i] = temp.val;
                temp = temp.next;
            }
            top++;

            for(int i=top; i<=bottom && temp!=null; i++){
                mat[i][right] = temp.val;
                temp = temp.next;
            }
            right--;

            for(int i=right; i>=left && temp!=null; i--){
                mat[bottom][i] = temp.val;
                temp = temp.next;
            }
            bottom--;

            for(int i=bottom; i>=top && temp!=null; i--){
                mat[i][left] = temp.val;
                temp = temp.next;
            }
            left++;

        }

        return mat;
    }
}