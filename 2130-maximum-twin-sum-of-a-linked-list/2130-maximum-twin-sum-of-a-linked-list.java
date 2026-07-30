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
    public int pairSum(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        int[] a = new int[size/2];
        temp = head;
        int count = 0;
        while(temp!=null){
            if(count<size/2){
                a[count] += temp.val;
            }
            else{
                a[size-1-count] += temp.val;
            }
            temp = temp.next;
            count++;
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            ans = Math.max(ans, a[i]);
        }
        return ans;
    }
}