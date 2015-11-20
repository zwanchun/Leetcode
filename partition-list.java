/*Partition List
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

/* Using two nodes to link smaller and larger nodes, and then connect two nodes
note: do not forget to make the next reference null when link each node to the new head
*/

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return head;
        ListNode dummy1=new ListNode(0);
        ListNode dummy2=new ListNode(0);
        ListNode small=dummy1;
        ListNode large=dummy2;
        while(head!=null){
            ListNode next=head.next;
        	head.next=null;
            if(head.val<x){
                small.next=head;
                small=small.next;
            }
            else{
                large.next=head;
                large=large.next;
            }
            head=next;
        }
        if(dummy1.next==null){
            return dummy2.next;
        }
        if(dummy2.next==null){
            return dummy1.next;
        }
        small.next=dummy2.next;
        return dummy1.next;
        
    }
}
