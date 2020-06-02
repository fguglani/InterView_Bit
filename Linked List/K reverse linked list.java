/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head, int b) 
    {
        int n=b;
        
        if(n==1)
        {
            return head;
        }
        //According to the question we b will be a factor of len(list).So we should not be considering cases where we will be left with elements to reverse
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        //we will split it into two parts to get head
        while(n-->0 && curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //reverse first b elements
        ListNode last=head;
        head.next=curr;
        head=prev;
        //adjust the head to prev 
        //we got our head pointer.
        while(curr!=null)
        {
            n=b;
            ListNode first=next;//will be pointing to last element e.g. let the list be 1->2->3->4 with b=2 so first is pointing to 3 because three will be the last element of this list
            while(n-->0)
            {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next; 
            }//reverse b elements
            last.next=prev;
            last=first;
            first.next=curr;
            first=first.next;
            //fix the last and first pointers
        }
        return head;
        
    }
}
