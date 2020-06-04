public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> a) 
    {
        //This is quite evident that we need to make sure we dont check the series for each 
        //number otherwise we will end up at quadratic complexity.
        HashSet<Integer> set=new HashSet<>();
        for(int i:a)
        {
            set.add(i);
        }
        //Add all elements to the set we need not worry about duplicates
        int max=1;
        for(int i:set)
        {
            int curr=i;
            int count=0;
            if(!set.contains(curr-1))//most important statement:-We will only check when we find we are the first element of that continuous series
            {
                while(set.contains(curr++))//we will calculate how many numbers are there in that series
                {
                    count++;
                }
            }
            max=Math.max(count,max);//Result is the max possible numbers in that series.
        }
        
        return max;
    }
}
