/*Sort List
Sort a linked list in O(n log n) time using constant space complexity.
*/

/*solution:http://www.cnblogs.com/yuzhangcmu/p/4131885.html*/

//merge sort
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode mid=findMiddle(head);
        ListNode right=sortList(mid.next);
        mid.next=null;
        ListNode left = sortList(head);
        return merge(left,right);
        
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy=new ListNode(0);
        ListNode current=dummy;
        while(head1!=null&&head2!=null){
            if(head1.val<=head2.val){
                current.next=head1;
                head1=head1.next;
            }
            else{
                current.next=head2;
                head2=head2.next;
            }
            current=current.next;
        }
        if(head1!=null) current.next=head1;
        else current.next=head2;
        return dummy.next;
    }
    
}

