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
    public ArrayList<Integer> preorderTraversal(TreeNode root) 
    {
        //We want to imitate the the things that are carried out by internal stack
        if(root==null)return new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();//Initialising arraylist to store ans
        Stack<TreeNode> s=new Stack<>();//Initialising stack to store the values.
        s.push(root);//Pushing the root
        while(!s.isEmpty())
        {
            root=s.pop();//taking first element out
            ans.add(root.val);//adding it to the ans
            if(root.right!=null)
            {
                s.push(root.right);//saving both its right and left child..its LIFO--->So whatever goes later comes out first.
            }
            if(root.left!=null)
            {
                s.push(root.left);//right goes first and left goes later
            }
        }
        
        return ans;
    }
}
