public class Solution {
    public int minDistance(String A, String B) 
    {
        /*
        The idea here is if we take a word as a whole and other word one by one how many 
        actions we need to perform.
        So this is the way we fill the table
        Let us take a as abcd b as acd
        */
        int n=A.length();
        int m=B.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0)//If we dont take character from 'A' then we have to take number of characters equal to b
                {
                    dp[i][j]=j;
                }
                else if(j==0)//Same goes for 'B'
                {
                    dp[i][j]=i;
                }
                else if(A.charAt(i-1)==B.charAt(j-1))//If character for both Strings are equal then we dont have to do anything
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;//Here we select operation and increase our count by 1  
                }
            }
        }
        
        return dp[n][m];
    }
}
