/*Rotate List
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

/* another solution: http://fisherlei.blogspot.com/2013/01/leetcode-rotate-list.html*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0) return head; 
        int length=getLength(head);
        k=k%length;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        head=dummy;
        
        for(int i=0;i<k;i++){
            head=head.next;
        }
        ListNode tail = dummy;
        while(head.next!=null){
            head=head.next;
            tail=tail.next;
        }
        head.next=dummy.next;
        dummy.next=tail.next;
        tail.next=null;
        return dummy.next;
    }
    
    private int getLength(ListNode head){
        int length=0;
        while(head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
}
