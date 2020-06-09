public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int hammingDistance(final List<Integer> a) 
    {
        //The catch in this problem is the way to check how many numbers differ at every position
        //Calculate number of ones and zeros at every position
        //Multiply with two because we will be calculating int the opposite direction also
        long ans=0;
        int n=a.size();
        for(int j=0;j<32;j++)
        {
            long ones=0;
            long zeros=0;
            for(int i=0;i<n;i++)
            {
                if((a.get(i) & (1<<j))==0)
                {
                    zeros++;//calculating zeros
                }
                else
                {
                    ones++;//calculating ones
                }
            }
            ans+=(zeros*ones);
        }
        return (int)((ans*2L)%1000000007);//Dont declare mod inside a variable there is some issue with compiler
    }
}
