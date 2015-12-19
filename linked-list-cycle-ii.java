/*Linked List Cycle II
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/

/*solution:http://bookshadow.com/weblog/2015/07/10/leetcode-linked-list-cycle-ii/*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null){
            fast=fast.next;
            if(fast==null) break;
            fast=fast.next;
            slow=slow.next;
            if(fast==slow){
                ListNode extra_slow=head;
                while(extra_slow!=slow){
                    extra_slow=extra_slow.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    
        
    }
}
