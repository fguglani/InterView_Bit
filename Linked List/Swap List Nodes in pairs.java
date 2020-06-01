/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) 
    {
        //If we have less than or equal to one node we cannot swap it
        if(head==null || head.next==null)
        {
            return head;
        }
        //Fixing our head we need to make sure about three pointers
        /*
        
        Let a list be 1->2->3->4->null;
        While swapping 1 and 2 we need to make sure we have a pointer at 3
        
               
            So 1   ->  2     ->   3____
               ^       ^          ^
               |       |          |
            curr    curr.next   curr_nn
            
        */
        ListNode curr=head;
        ListNode curr_nn=head.next.next;
        
        head=head.next;
        head.next=curr;
        curr.next=curr_nn;
        //swapping the two nodes
        ListNode prev=curr;//making sure we are able to bind it with rest of list
        curr=curr.next;
        if(curr!=null && curr.next!=null)//(Cases where len=2 or 3)if our list is exhausted and if len=2 then curr will be null if it is off curr.next will be null
        curr_nn=curr.next.next;
       
        while(curr!=null && curr.next!=null)
        {
            curr=curr.next;
            curr.next=prev.next;
            prev.next.next=curr_nn;
            prev.next=curr;
            
            prev=curr.next;//moving prev to end of list that has been swapped
            curr=curr.next.next;
            if(curr!=null && curr.next!=null)//if our list is exhausted curr will be null if it is off curr.next will be null
            {
            curr_nn=curr.next.next;
            }
        }
        
        return head;
        
    }
}
