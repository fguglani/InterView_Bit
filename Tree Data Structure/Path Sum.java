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
    public int hasPathSum(TreeNode root, int sum) 
    {
        //We need to check from root to leaf if we can manage a particular sum
        if(root==null)
        {
            return 0;
        }//if we reach end just return 0;
        
        if(root.left==null && root.right==null && sum==root.val)
        {
            return 1;//otherwise if we reach leaf node and sum left is equal to value of node
        }
        
        sum-=root.val;//otherwise continue decreasing the sum value 
        int ans=hasPathSum(root.left,sum) | hasPathSum(root.right,sum);//explore left subtree and right subtree
        sum+=root.val;//add the value while backtracking
        
        return ans;
    }
}
