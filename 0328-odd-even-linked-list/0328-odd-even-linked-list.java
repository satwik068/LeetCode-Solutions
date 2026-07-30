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
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        int count = 0;
        ListNode temp1 = head;
        ListNode temp2 = temp1.next;
        ListNode eve = temp2;

        while(temp2!=null){
            count++;
            if(temp2.next==null && count%2!=0){
                temp2 = temp2.next;
                continue;
            }
            temp1.next = temp2.next;
            temp1 = temp2;
            temp2 = temp2.next;
        }
        temp1.next = eve;
        return head;
    }
}