/*Odd Even Linked List
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode l1=new ListNode(0);
        ListNode l2=new ListNode(0);
        ListNode dummy1=l1;
        ListNode dummy2=l2;
        while(head!=null){
            l1.next=head;
            l1=l1.next;
            head=head.next;
            if(head!=null){
                l2.next=head;
                head=head.next;
                l2=l2.next;
            }
            else{
                l2.next=null;
            }
        }
        l1.next=dummy2.next;
        return dummy1.next;
        
    }
}
