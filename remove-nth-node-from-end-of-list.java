/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        
        if(n<=0) return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        
        ListNode fast=head;
        ListNode slow=dummy;
        
        for(int i=0;i<n;i++){
            if(fast!=null){
                fast=fast.next;
            }
            else return head;
        }
        
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        
        slow.next=slow.next.next;
        return dummy.next;
        
        
        
    }
}
