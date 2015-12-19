/*Reverse Linked List II
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||m>=n) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        head=dummy;
        
        for(int i=1;i<m;i++){
            if(head==null) return null;
            head=head.next;
            
        }
        
        ListNode premNode=head, mNode=head.next;
        ListNode nNode=mNode, postnNode=nNode.next;
        
        for(int i=m;i<n;i++){
            if(postnNode==null) return null;
            ListNode tmp=postnNode.next;
            postnNode.next=nNode;
            nNode=postnNode;
            postnNode=tmp;
        }
        premNode.next=nNode;
        mNode.next=postnNode;
        
        return dummy.next;
        
        
    }
}
