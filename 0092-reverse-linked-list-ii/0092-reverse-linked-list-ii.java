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

    public ListNode position(ListNode head,  int pos){
        if(pos<=0) return null;
        ListNode temp = head;
        while(temp!=null && pos>1){
            temp = temp.next;
            pos--;
        }
        return temp;
    }

   
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right){
            return head;
        }
        ListNode l = position(head, left-1);
        ListNode temp1 = position(head, left);
        ListNode temp2 = temp1.next;
        ListNode temp3 = temp2.next;
        ListNode r = position(head, right);

        if(l==null){
            head = r;
        }
        else{
            l.next = r;
        }
        temp1.next = r.next;
        
        while(temp2!=r && temp3!=null){
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;
            temp3 = temp3.next;
        }
        temp2.next = temp1;
        // head = temp2;
        return head;
    }
}