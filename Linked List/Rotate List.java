/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    //The motive here is to rotate the list and given a possibility b>=len of list
    public int len(ListNode head)
    {
        int c=0;//So we calculate the len of list if we use c=0 then head!=null and if we use c=1 then curr.next!=null
        ListNode curr=head;
        while(head!=null)
        {
            head=head.next;
            c++;
        }
        return c;
    }
    public ListNode rotateRight(ListNode head, int b) 
    {
        int l=len(head);//calucalte the length
        int rot=b%l;//take the mod
        if(rot==0)//so now b>=0 && b<len if b==0 then simply return head
        {
            return head;
        }
        ListNode slow=head;
        int c=1;
        //Find bth node from end
        while(c<rot)
        {
            c++;
            slow=slow.next;//move bth node from start
        }
        ListNode prev=null;
        ListNode curr=head;
        while(slow.next!=null)
        {
            prev=curr;
            slow=slow.next;//move slow.next till end 
            curr=curr.next;//curr will be at nth-(b-1)
        }
        slow.next=head;//slow should point to head
        prev.next=null;//prev will have next as null
        
        return curr;
    }
}
