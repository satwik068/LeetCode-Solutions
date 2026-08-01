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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            }
            else{
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            }
        }

        temp.next = (temp1!=null)? temp1:temp2;
        return dummyHead.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = (slow==null)? head: slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);
    }
}