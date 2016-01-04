/*Reverse Nodes in k-Group
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k<=1) return head;
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        
        head=dummy;
        while(head.next!=null){
            head=reverseNextKGroup(head,k);
        }
        
        return dummy.next;
        
    }
    
    private ListNode reverseNextKGroup(ListNode head, int k){
        ListNode next=head;
        //check if there are k nodes
        for(int i=0;i<k;i++){
            if(next.next==null) return next;//tail node
            next=next.next;
        }
        
        //reverse
        ListNode n1=head.next;
        ListNode prev=head, curt=n1;
        for(int i=0;i<k;i++){
            ListNode temp=curt.next;
            curt.next=prev;
            prev=curt;
            curt=temp;
        }
        
        n1.next=curt;
        head.next=prev;
        return n1;
        
        
        
    }
}
