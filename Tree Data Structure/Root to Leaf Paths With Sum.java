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
    ArrayList<ArrayList<Integer>> ans;
    ArrayList<Integer> temp;
    Solution()
    {
        ans=new ArrayList<>();//Initialising ans for ArrayList<ArrayList<Integer>>
        temp=new ArrayList<>();//Initialising temp for ArrayList<Integer>
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) 
    {
        if(root==null)
        {
            return ans;
        }
        if(root.left==null && root.right==null && sum==root.val)//if we hit a leaf node ans left value of sum ==that node value
        {
            temp.add(root.val);//add that node to the list
            ans.add(new ArrayList<>(temp));//add list to the ans
            temp.remove(temp.size()-1);//remove that node from the list
            return ans;
        }
        
        temp.add(root.val);//add the root value
        pathSum(root.left,sum-root.val);//traverse left subtree
        pathSum(root.right,sum-root.val);//traverse right subtree
        temp.remove(temp.size()-1);//remove the last element
        
        return ans;
    }
}
