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
    // How do we ensure that that at every level our left sub tree is equal to right sub tree
    //By picking elements in such a way that we have equal numbers of element in the left subtree and right subtree or at max a difference of 1
    //We will find mid at every level and start breaking the tree further
    public TreeNode formBST(int s,int e,List<Integer> a)
    {
        if(s<=e)//to make sure we dont overflow
        {
        int mid=(s+e)/2;
        if(mid<a.size())//this will make sure we dont try to access elements not available
        {
        TreeNode root=new TreeNode(a.get(mid));//make mid as the node and 
        root.left=formBST(s,mid-1,a);//will find its left subtree 
        root.right=formBST(mid+1,e,a);//find its right subtree
        return root;
        }
        }
        return null;
    }
    
    
    public TreeNode sortedArrayToBST(final List<Integer> a) 
    {
        if(a.size()==1)
        {
            return new TreeNode(a.get(0));
        }
        TreeNode root=formBST(0,a.size()-1,a);
        return root;
    }
}
