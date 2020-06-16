public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> a) 
    {
        //The concept behind this question is when  the prefix sum repeats for an array it means
        //the sum between two same prefix sum is zero.But there is a small catch i.e.when the sum becomes
        //actually zero that means the length is not end-start it is end+1-start but in other case it is 
        //end-start
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int maxlen=0;
        int maxst=-1;
        int maxen=0;
        for(int i=0;i<a.size();i++)
        {
            sum+=a.get(i);
            if(sum==0)
            {
                maxlen=i+1;
                maxen=i;
                maxst=-1;
            }
            else if(sum!=0)
            {
                if(map.containsKey(sum))
                {
                    int start=map.get(sum);
                    int end=i;
                    if(maxlen<(end-start))
                    {
                        maxst=start;
                        maxen=end;
                        maxlen=(end-start);
                    }
                }
                else
                {
                    map.put(sum,i);
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        
        if(maxen==0 && maxlen==0)
        {
            return ans;
        }
        
        for(int i=maxst+1;i<=maxen;i++)
        {
            ans.add(a.get(i));
        }
        return ans;
    }
}
