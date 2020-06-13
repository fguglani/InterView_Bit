public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> a) 
    {
        //Smallest non decreasing list can be of size 1
        //So we fix length of each list as 1
        //The iterate over list taking one element at a time and checking if starting from this list is maximum or not
        int n=a.size();
        int dp[]=new int[n];
        int max=1;
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(a.get(i)>a.get(j))
                {
                    dp[i]=Math.max(1+dp[j],dp[i]);
                }
            }
            max=Math.max(dp[i],max);
        }
        //System.out.println(Arrays.toString(dp));
        
        return max;
    }
}
