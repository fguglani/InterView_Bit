public class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> a) 
    {
        //Approach for this question is very simple and straight forward
        //Take the min of all possibilities i.e here coming from up or coming from left
        int n=a.size();
        if(n==0)
        {
            return 0;
        }
        int m=a.get(0).size();        
        int dp[][]=new int[n][m];
        dp[0][0]=a.get(0).get(0);
        for(int i=1;i<n;i++)//First column 0 because there is no chance of coming from left
        {
            dp[i][0]=a.get(i).get(0)+dp[i-1][0];
        }
        for(int i=1;i<m;i++)//First row 0 because there is no chance of coming from up
        {
            dp[0][i]=a.get(0).get(i)+dp[0][i-1];
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                dp[i][j]=a.get(i).get(j)+Math.min(dp[i-1][j],dp[i][j-1]);//Get the min of coming from up or coming from left
            }
        }
        
        return dp[n-1][m-1];
    }
}
ए