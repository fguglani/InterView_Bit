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
    int p;
    public TreeNode createTree(ArrayList<Integer> in,ArrayList<Integer> pre,HashMap<Integer,Integer> map,int s,int e)
    {
        //We use preorder traversal to find the next number and inorder to find its place
        //The element we take from preorder is found out in inorder and that us to know the elements in its left subtree and in its right subtree
        //we will follow the same order vist yourself-->visit left child-->visit right child
        //We use HashMap to store indexes of Inorder array to get the query in o(1).
        if(s>e || p==in.size())return null;
        TreeNode root=new TreeNode(pre.get(p++));
        if(s==e)return root;
        int ind=map.get(root.val);
        root.left=createTree(in,pre,map,s,ind-1);
        root.right=createTree(in,pre,map,ind+1,e);
        return root;
    }
    
    public TreeNode buildTree(ArrayList<Integer> pre, ArrayList<Integer> in) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<in.size();i++)
        {
            map.put(in.get(i),i);   
        }
        p=0;
        return createTree(in,pre,map,0,in.size()-1);
    }
}
