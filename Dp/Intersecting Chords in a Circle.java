public class Solution {
    public int chordCnt(int a) 
    {
        //The idea of dp here is to keep previous track constant and push for the newer one
        //e.g n=1 we can draw one chord b/w 1 and 2 
        //for n=2 we should start thinking of scenarios where chord is constant b/w 1 and 2 and what other posibilities we can have
        //We will do here catalan numbers
        int dp[]=new int[a+1];
        dp[0]=1;
        dp[1]=1;
        int mod=1000000007;
        int n=dp.length;
        for(int i=2;i<n;i++)
        {
            int j=0;
            int k=i-1;
            long sum=0;
            while(j<i)
            {
                sum+=((long)(dp[i])+((long)(dp[j])*(long)dp[k]));
                sum%=mod;
                j++;
                k--;
            }
            dp[i]=(int)(sum);
        }
        
        return dp[a];
        
    }
}
