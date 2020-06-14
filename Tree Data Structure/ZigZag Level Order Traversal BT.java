/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) 
    {
        //The game here is to figure out the pattern
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(a.val);
        ans.add(new ArrayList<>(temp));
        temp.clear();
        //We will use two stacks here.
        Stack<TreeNode> s1=new Stack<>();//one for right to left
        Stack<TreeNode> s2=new Stack<>();//other for left to right
        s1.push(a);
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            int size1=s1.size();
            while(size1-->0)
            {
                TreeNode p=s1.pop();
                if(p.right!=null)//fill the other stack from which you are popping out the elements
                {
                    s2.add(p.right);
                    temp.add(p.right.val);
                }
                if(p.left!=null)//fill the other stack from which you are popping out the elements
                {
                    s2.add(p.left);
                    temp.add(p.left.val);
                }
            }
            if(temp.size()!=0)
            ans.add(new ArrayList<>(temp));
            temp.clear();
            int size2=s2.size();
            while(size2-->0)
            {
                TreeNode p=s2.pop();
                if(p.left!=null)
                {
                    s1.add(p.left);
                    temp.add(p.left.val);
                }
                if(p.right!=null)
                {
                    s1.add(p.right);
                    temp.add(p.right.val);
                }
            }
            if(temp.size()!=0)
            ans.add(new ArrayList<>(temp));
            temp.clear();
        }
        
        return ans;
    }
}
