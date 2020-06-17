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
public class Solution 
{
    int p;
    public TreeNode createTree(ArrayList<Integer> in,ArrayList<Integer> post,int s,int e)
    {
        //We need two things one the element and the where to place them.
        //So we use postorder traversal to get the elements and use inorder traversal to find their location\
        //As it is easier to find the left and right half in inorder traversal
        if(s>e || p<0)//breaking condition
        {
            return null;
        }
        
        TreeNode root=null;
        root=new TreeNode(post.get(p--));//we will use post order to get the elements
        
        if(s==e)//if s==e that is only one element in left or right subtree
        return root;
        
        int index=linearSearch(in,s,e,root.val);//find index of that number in inorder traversal
        
        root.right=createTree(in,post,index+1,e);//WE use reverse of order that is visit yourself then right then left
        root.left=createTree(in,post,s,index-1);
        
        return root;
        
        
    }
    public int linearSearch(ArrayList<Integer> in,int s,int e,int val)
    {
        for(int i=s;i<=e;i++)
        {
            if(in.get(i)==val)
            {
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> post) 
    {
        p=post.size()-1;
        return createTree(in,post,0,post.size()-1);
    }
}
