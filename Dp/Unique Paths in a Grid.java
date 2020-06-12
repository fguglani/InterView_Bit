public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) 
    {
        //The idea here is very simple again.We just need to check if it is possible to come from up and to come from left
        int n=a.size();
        //If we dont have anything in the matrix or if the starting point is blocked we dont need to calculate any cases
        if(n==0 || a.get(0).get(0)==1)
        return 0;
        int m=a.get(0).size();
        
        int dp[][]=new int[n][m];
        dp[0][0]=1;
        //Checking in column=0 as coming from left is not any option here
        for(int i=1;i<n;i++)
        {
            if(a.get(i).get(0)==0)
            dp[i][0]=dp[i-1][0];
        }
        //Checking in row=0 as coming from up is not option here
        for(int i=1;i<m;i++)
        {
            if(a.get(0).get(i)==0)
            dp[0][i]=dp[0][i-1];
        }
        //If cell is not blocked check if we can come from up or down or both.
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(a.get(i).get(j)==0)
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        
        return dp[n-1][m-1];
    }
}
