/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reorderList(ListNode head) 
    {
        /*
        As we dont have any back pointers so we need a way to traverse the list in reverse manner
        So I split the list in two parts and reversed the other one
        e.g 1->2->3->4->null
        */
        if(head.next==null || head.next.next==null || head==null)
        return head;//If any of these confitions arise you cannot reorder
        
        ListNode fast=head;
        ListNode slow=head;
        //First find middle element across which we will split 
        //For even we will take (n/2) element and for odd we will take (n/2)+1 element
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }//fast.next for odd and fast.next.next for even
        ListNode curr=slow.next;//we will start to reverse from middle+1
        slow.next=null;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //After reversing we have two pointers head as 1->2->null and prev as 4->3->null
        curr=head;
        next=null;
        ListNode prev_next=null;
        //No we will merge list as follows head.next will be prev and prev.next=head.next(stored in other pointer)
        while(curr!=null && prev!=null)
        {
            next=curr.next;
            prev_next=prev.next;
            curr.next=prev;
            prev.next=next;
            curr=next;
            prev=prev_next;
        }
        //Return head at the end
        return head;
    }
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reorderList(ListNode head) 
    {
        /*
        As we dont have any back pointers so we need a way to traverse the list in reverse manner
        So I split the list in two parts and reversed the other one
        e.g 1->2->3->4->null
        */
        if(head.next==null || head.next.next==null || head==null)
        return head;//If any of these confitions arise you cannot reorder
        
        ListNode fast=head;
        ListNode slow=head;
        //First find middle element across which we will split 
        //For even we will take (n/2) element and for odd we will take (n/2)+1 element
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }//fast.next for odd and fast.next.next for even
        ListNode curr=slow.next;//we will start to reverse from middle+1
        slow.next=null;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //After reversing we have two pointers head as 1->2->null and prev as 4->3->null
        curr=head;
        next=null;
        ListNode prev_next=null;
        //No we will merge list as follows head.next will be prev and prev.next=head.next(stored in other pointer)
        while(curr!=null && prev!=null)
        {
            next=curr.next;
            prev_next=prev.next;
            curr.next=prev;
            prev.next=next;
            curr=next;
            prev=prev_next;
        }
        //Return head at the end
        return head;
    }
}
