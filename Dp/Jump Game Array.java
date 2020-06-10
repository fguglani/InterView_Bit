public class Solution {
    public int canJump(ArrayList<Integer> a) 
    {
        if(a.size()==1)
        {
            return 1;
        }
        
        //Trying to solve in more simple manner
        //We wish to know if we can reach end or not
        int n=a.size();
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(i>max)//If we surpass the max we reach then we cant reach the end
            {
                return 0;
            }
            max=Math.max(i+a.get(i),max);//Calculate maximum we can reach
            if(max>=n)
            {
                return 1;//if we can surpass the length then answer is true
            }
        }
        
        return 0;
        
        //Using Dp
        /*int n=a.size();
        boolean dp[]=new boolean[n];
        dp[0]=true;
        for(int i=1;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(j+a.get(j)>=i && dp[j]==true)
                dp[i]=true;
            }
        }
        
        return dp[n-1]?1:0;
        */
    }
}
