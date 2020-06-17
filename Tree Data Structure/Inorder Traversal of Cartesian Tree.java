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
    
    public TreeNode createTree(ArrayList<Integer> a,int s,int e)
    {
        //Root will be the biggest element in the whole tree that sums it our approach
        //if we can find root we can split tree into left half and right half then we will recursively
        //do the same for both sides find max index of left subtree and right subtree.
        if(s>e)return null;
        int ind=maxele(a,s,e);
        TreeNode root=new TreeNode(a.get(ind));
        if(s==e)return root;
        root.left=createTree(a,s,ind-1);
        root.right=createTree(a,ind+1,e);
        return root;
    }
    public int maxele(ArrayList<Integer> a,int s,int e)
    {
        int max=Integer.MIN_VALUE;
        int ind=-1;
        for(int i=s;i<=e;i++)
        {
            if(a.get(i)>max)
            {
                max=a.get(i);
                ind=i;
            }
        }
        
        return ind;
    }
    
    public TreeNode buildTree(ArrayList<Integer> a) 
    {
        return createTree(a,0,a.size()-1);
    }
}
