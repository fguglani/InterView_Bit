public class Solution {
    public int solve(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) 
    {
        /*
        Let A={1,2,7} B={4,5,9} C={6,7}
        First Triplet-->(7,9,7) Res=>9-7=2 maxe=9 so b--;
        Second Triplet-->(7,5,7) Res=>7-5=2 maxele=7 c--;
        Third Triplet--->(7,5,6) Res=>7-5=2 maxele=7 a--;
        Forth Triplet-->(2,5,6)  Res=>6-2=4 maxele=6 c--;
        Loop ends
        Ans=2
        */
       int i=a.size()-1;
       int j=b.size()-1;
       int k=c.size()-1;
       int ans=Integer.MAX_VALUE;
       while(i>=0 && j>=0 && k>=0)
       {
           //The idea is to reduce the max element and as a result minimising the difference.
           int maxe=Math.max(a.get(i),Math.max(b.get(j),c.get(k)));
           int mine=Math.min(a.get(i),Math.min(b.get(j),c.get(k)));
           ans=Math.min(ans,maxe-mine);
           if(a.get(i)==maxe)i--;
           if(b.get(j)==maxe)j--;
           if(c.get(k)==maxe)k--;
       }
       
       return ans;
    }
}
