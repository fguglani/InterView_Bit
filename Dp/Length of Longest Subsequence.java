public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> a) 
    {
        //We have to find max length in which first the length increases and then decreases.
        //The only catch is one of these lengths can be zero
        //e.g 8 4 2 1 has increasing length zero
        if(a.size()==0)
        {
            return 0;
        }
        //We will find max increasing length to the left and max decreasing length to the right for each element
        List<Integer> inc=new ArrayList<Integer>();
        List<Integer> dec=new ArrayList<Integer>();
        
        for(int i:a)
        {
            inc.add(1);
            dec.add(1);
        }
        //Intialise by 1 becuase at least length of the series will be one
        int max=1;
        for(int i=1;i<a.size();i++)//Finding increasing series to the left series 
        {
            for(int j=i-1;j>=0;j--)
            {
                if(a.get(i)>a.get(j))
                {
                    inc.set(i,Math.max(inc.get(i),inc.get(j)+1));
                }
            }
        }
        //Finding decreasing series to the right
        for(int i=a.size()-2;i>=0;i--)
        {
            for(int j=i+1;j<a.size();j++)
            {
                if(a.get(j)<a.get(i))
                {
                    dec.set(i,Math.max(dec.get(i),dec.get(j)+1));
                }
            }
        }
        //Checking the max length
        for(int i=0;i<a.size();i++)
        {
            max=Math.max(max,inc.get(i)+dec.get(i)-1);
        }
        return max;
    }
    
}
