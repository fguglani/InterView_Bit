public class Solution {
    public int nchoc(int k, ArrayList<Integer> b) 
    {
        //We need always the biggest element So priority Queue is the best data structure
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:b)
        {
            pq.add(i);
        }
        long ans=0;
        int mod=1000000007;
        //Loop for k units of time 
        while(k-->0)
        {
            int x=pq.remove();
            ans=((ans%mod)+(x%mod))%mod;
            pq.add(x/2);
        }
        
        return (int)ans;
    }
}
