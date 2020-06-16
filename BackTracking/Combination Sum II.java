public class Solution {
    
    public void solve(ArrayList<Integer> a,HashSet<ArrayList<Integer>> set,int sum,int i,int n,ArrayList<Integer> temp)
    {
        //We will add elements to the arraylist if we get the answer==sum we will add it to HashSet
        if(sum==0)
        {
            set.add(new ArrayList<Integer>(temp));
            return;
        }
        //if we reach end of Array or sum becomes negative just return
        if(sum<0 || i==n)
        {
            return;
        }
        temp.add(a.get(i));
        solve(a,set,sum-a.get(i),i+1,n,temp);
        temp.remove(temp.get(temp.size()-1));//remove the last element and skip that element
        solve(a,set,sum,i+1,n,temp);
    }
    
    
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) 
    {
        Collections.sort(a);
        HashSet<ArrayList<Integer>> set=new HashSet<>();//We will use HashSet to store values so that no repetition occurs
        solve(a,set,b,0,a.size(),new ArrayList<Integer>());
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(ArrayList<Integer> i:set)
        {
            ans.add(i);
        }
        
        return ans;
    }
}
