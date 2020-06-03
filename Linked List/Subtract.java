/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode subtract(ListNode head) 
    {
        //The plan is simple here as we need to access last and first at the same time or we can cut seprate the right half use the value and put it back again
        //Steps to involve here 
        //1->Find the middle element-1
        if(head==null || head.next==null)
        {
            return head;
        }
        
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        //We found the middle element in case of odd and middle-1 in case of even
        ListNode cut=slow;
        slow=slow.next;
        cut.next=null;
        
        //2->Reverse the second half of the list(right half)
        ListNode prev=null;
        ListNode curr=slow;
        ListNode next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //3->Its time to iterate both lists and change the values,length of right half<=left half so we will use that
        curr=prev;
        ListNode curr2=head;
        while(curr!=null)
        {
            curr2.val=-curr2.val+curr.val;
            curr=curr.next;
            curr2=curr2.next;
        }
        
        //4->Time to put the reversed list back after reversing it again
        curr=prev;
        prev=null;
        next=null;
         while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //5->Join the left and the right half
        cut.next=prev;
        
        return head;
        
    }
}
