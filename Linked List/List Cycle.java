/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode a) 
    {
        /*
        Let a list be 1-2-3-4-5
                          ^   |                              
                          |___|
        */
        if(a==null)
        {
            return a;
        }
        else if(a.next==a)
        {
            return a;
        }
        
        ListNode slow=a;//Intialise two pointers slow and fast
        ListNode fast=a.next;
        
        while(slow!=fast && fast!=null && fast.next!=null)//checking if there is a cycle or not if fast becomes null then there is no cycle
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        if(fast==null || fast.next==null)
        {
            return null;
        }
        
        //If there is no cycle then it is fast==slow in the loop let us take both are at 4
        int n=0;
        fast=fast.next;//making fast point towards 5
        while(fast!=slow)
        {
            fast=fast.next;
            n++;
        }
        //n will become two
        slow=a;//Slow pointing towards head
        while(n-->0)
        {
            slow=slow.next;
        }
        //slow will point at 3
        fast=a;//Fast pointing towards head
        //We have created the difference in the size of loop so when now slow.next-->fast that will be the starting point
        while(slow.next!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        return fast;
    }
}
