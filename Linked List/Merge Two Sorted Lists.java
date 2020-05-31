/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) 
    {
        ListNode prev=null;//To maintain last pointer and add values in o(1)
        ListNode temp=null;//To get the values
        ListNode head=null;//To maintain head pointer
        while(a!=null || b!=null)
        {
            if(a!=null && b!=null)
            {
                if(a.val<b.val)//if b.val is greater get a pointer and vice versa
                {
                    temp=a;
                    a=a.next;
                }
                else
                {
                    temp=b;
                    b=b.next;
                }
            }
            else if(a!=null)//if b is empty and a is not empty put all values of a at the end
            {
                temp=a;
                a=a.next;
            }
            else//if a is empty and b is not empty put all values of b at end
            {
                temp=b;
                b=b.next;
            }   
            if(prev==null)//if prev is null i.e we have not initialised first element 
            {
                prev=temp;
                head=prev;
            }
            else
            {
                prev.next=temp;//use prev to add elements
                prev=prev.next;
            }
        }
        
        return head;
    }
}
