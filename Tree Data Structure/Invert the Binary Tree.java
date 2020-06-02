
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
    public TreeNode invertTree(TreeNode root) 
    {
        if(root==null)
        {
            return root;
        }
        
        invertTree(root.left);//traverse left till leftmost element
        invertTree(root.right);//traverse right till righttmost element
        
        TreeNode temp=root.left;//just swap the nodes as we swap integers
        root.left=root.right;
        root.right=temp;
        
        return root;//return the root
    }
}
