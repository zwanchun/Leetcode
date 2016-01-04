/*Reorder List
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) return;
        ListNode mid=findMiddle(head);
        ListNode head2=reverse(mid.next);
        head=merge(head,head2);
    }
    
    private ListNode findMiddle(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
    
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy=new ListNode(0);
        ListNode current=dummy;
        while(head1!=null&&head2!=null){
            current.next=head1;
            head1=head1.next;
            current=current.next;
            current.next=head2;
            head2=head2.next;
            current=current.next;
        }
        if(head1!=null){
            current.next=head1;
            current=current.next;
        }
        current.next=null;
        
        return dummy.next;
        
    }
}
