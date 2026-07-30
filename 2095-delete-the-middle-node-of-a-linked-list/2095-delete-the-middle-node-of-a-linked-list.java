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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null){
            head = null;
            return head;
        }   
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        temp = head;
        int index = size/2;
        while(index-1>0){
            temp = temp.next;
            index--;
        }
        ListNode temp2 = temp.next;
        temp.next = temp2.next;
        temp2.next = null;
        return head;
    }
}