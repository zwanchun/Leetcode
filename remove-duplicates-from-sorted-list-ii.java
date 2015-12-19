/* Remove Duplicates from Sorted List II
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode cur=head.next;
        while(cur!=null){
            if(cur.val!=prev.next.val){
                prev=prev.next;
                cur=cur.next;
            }
            else{
                while((cur!=null)&&(cur.val==prev.next.val)){
                    cur=cur.next;
                }
                if(cur!=null){
                    prev.next=cur;
                    cur=cur.next;
                }
                else{
                    prev.next=null;
                    break;
                }
            }
        }
        return dummy.next;
            
        
        
    }
}
