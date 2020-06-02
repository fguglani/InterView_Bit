/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) 
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        //if head is null or list has only one element there is no point of doing anything
        ListNode great=null;
        ListNode great_prev=null;//lets create two lists one for greater tha
        ListNode less=null;
        ListNode less_prev=null;//other one for less than
        ListNode curr=head;
        while(curr!=null)
        {
            if(curr.val<x)
            {
                if(less==null)//if less has value equal to null put value in less
                {
                    less=curr;
                    less_prev=curr;
                }
                else
                {
                    less_prev.next=curr;//use less_prev to put values in list in o(1)
                    less_prev=less_prev.next;
                }
            }
            else//same as less
            {
                if(great==null)
                {
                    great=curr;
                    great_prev=curr;
                }
                else
                {
                    great_prev.next=curr;
                    great_prev=great_prev.next;
                }
            }
            curr=curr.next;//implement current pointer
        }
        if(great_prev!=null)//if we have elements greater than x then make last pointer point to null
        {
            great_prev.next=null;
        }
        else
        {
            less_prev.next=null;
        }
        
        if(less==null)
        {//if there is no value<x then return great
            return great;
        }
        else
        {
            less_prev.next=great;//join less to great
            return less;
        }
    }
}
