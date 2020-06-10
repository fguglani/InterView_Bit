public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> a, int k) 
    {
        int n=a.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        //The only thing we need to make sure is when k=0;
        for(int i:a)
        {
            //Fill the HashMap
            if(map.containsKey(i))map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        
        for(int i:a)
        {
            //Check if map contains i+k
            if(map.containsKey(i+k))
            {
                //Check if i==i+k then we should have more than one instance of i+k
                if((i==i+k && map.get(i+k)>1) || (i!=i+k))return 1;
            }
        }
        
        return 0;
    }
}
