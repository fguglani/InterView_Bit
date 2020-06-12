/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    
    //This question is on the trickier side and using hashmap we will use o(n) space but we can do it in o(1) lets see
    //Lets take a list 1->2->3
    //Lets create copy of the list and attach to the list i.e
    //1   2   3   null
    // \ / \ / \ /
    //  1   2   3
    //This way we will be able to resolve random pointers easily
    //for eg we random pointer of 1 is 3 i.e head.random then to set for duplicate list we just have to do head.next.random=head.random.next
    //Finally break the list into two different list keeping in minf duplicate list.next will reach null first
    public RandomListNode copyRandomList(RandomListNode head) 
    {
        RandomListNode curr=head;
        while(curr!=null)
        {
            RandomListNode temp=new RandomListNode(curr.label);
            temp.next=curr.next;
            curr.next=temp;
            curr=curr.next.next;
        }
        curr=head;
        while(curr!=null)
        {
            if(curr.random!=null)//Any pointer kept as random can point to null so make sure that we check this scenario to avoid run time error
            curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        curr=head;
        RandomListNode root=head.next;
        RandomListNode head2=head.next;
        while(root.next!=null)
        {
            curr.next=curr.next.next;
            curr=curr.next;
            root.next=root.next.next;
            root=root.next;
        }
        
        return head2;
    }
}
