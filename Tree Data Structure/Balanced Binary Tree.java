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
 //We will calculate height and the difference in one parse
 class height
 {
     int h;//calculate the height
     boolean res;//calculate the result if tree below is balanced or not
     height(int h,boolean res)
     {
         this.h=h;
         this.res=res;
     }
 }
 
public class Solution {
    public int isBalanced(TreeNode a) 
    {
        if(solve(a).res)
        return 1;
        else
        return 0;
    }
    
    public height solve(TreeNode a)
    {
        if(a==null)//if we reach null the height is zero and tree is balanced
        {
            return new height(0,true);
        }
        height lh=solve(a.left);//calculate height of left subtree
        height rh=solve(a.right);//calculate height of right subtree
        boolean an=lh.res & rh.res;//check if tree below is balanced or not
        if(Math.abs(lh.h-rh.h)>1)//check current node is balanced or not
        {
            an=false;
        }
        
        return new height(1+Math.max(lh.h,rh.h),an);//update the height of the tree and result
        
    }
}
