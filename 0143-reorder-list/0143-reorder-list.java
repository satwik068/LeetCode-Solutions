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
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode ans = slow.next;
        slow.next = null;
        return ans;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp1 = head;
        ListNode temp2 = temp1.next;
        temp1.next = null;
        
        ListNode temp3 = temp2.next;
        
        while(temp3!=null){
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;
            temp3 = temp3.next;
        }
        temp2.next = temp1;
        head = temp2;
        return head;
    }

    public void reorderList(ListNode head) {
        ListNode head2 = reverseList(middle(head));
        ListNode temp = head;
        ListNode temp2 = null;
        ListNode temp3 = null;
        while(head2!=null){
            temp2 = temp.next;
            temp3 = head2.next;
            temp.next = head2;
            head2.next = temp2;
            temp = temp2;
            head2 = temp3;
        }
    }
}