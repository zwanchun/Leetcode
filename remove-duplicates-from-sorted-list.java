/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if(head==null||head.next==null) return head;
        ListNode pre=head;
        ListNode cur=head.next;
        while(cur!=null){
            if(cur.val==pre.val){
                cur=cur.next;
                pre.next=cur;
            }
            else{
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }  
}
