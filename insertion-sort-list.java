/*runtime:O(N^2)
space:O(1)
*/

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if(head == null||head.next == null)  
            return head;  
        ListNode sortedlisthead = new ListNode(0);  
        ListNode cur = head;
        while(cur!=null){  
            ListNode next = cur.next;  
            ListNode pre = sortedlisthead;  
            while(pre.next!=null && pre.next.val<cur.val)  
                pre = pre.next;  
            cur.next = pre.next;  
            pre.next = cur;  
            cur = next;  
        }  
        return sortedlisthead.next;  
        
    }
}
