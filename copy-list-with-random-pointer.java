
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
 
 
 /* runtime:O(N)
 space:O(1)
 */
 
 
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head==null) return null;
        RandomListNode curr=head;
        while(curr!=null){
            RandomListNode newnode=new RandomListNode(curr.label);
            newnode.next=curr.next;
            newnode.random=curr.random;
            curr.next=newnode;
            curr=newnode.next;
        }
        
        RandomListNode newhead=head.next;
        curr=head;
        
        while(curr!=null){
            RandomListNode newnode=curr.next;
            RandomListNode next=newnode.next;
            if(newnode.random!=null){
                newnode.random=newnode.random.next;
            }
            if(newnode.next!=null){
                newnode.next=newnode.next.next;
            }
            curr=next;
        }
        
        return newhead;
        
        
         
        
        
    }
}
