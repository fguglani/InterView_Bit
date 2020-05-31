/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head==null || n==0)
        {
            return head;
        }
        else
        {
        n=Math.abs(n);//Considering negatives also gave same answer.
        ListNode curr=head;//pointer to move forward
        ListNode prev=head;//pointer to delete element
        int c=0;
        while(c<n && curr!=null)//move n steps forward so the left length is k-n
        {
            curr=curr.next;
            c++;
        }
        if(curr==null && c<=n)//if we reach end and c<=n that is n is either length of list or more
        {
            return head.next;//return head.next
        }
        else
        {
            while(curr.next!=null)//else take curr.next pointer to last then prev pointer will be exactly one step behind destination
            {
                prev=prev.next;//
                curr=curr.next;
            }
            prev.next=prev.next.next;//Delete using prev pointer 
            return head;
        }
        }
    }
}
