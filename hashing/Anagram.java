public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) 
    {
        //The idea here is simple we can make sure two strings are anagrams if we sort them and then check 
        HashMap<String,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<a.size();i++)
        {
            char c[]=a.get(i).toCharArray();//pick every String
            Arrays.sort(c);//sort the string
            String s=new String(c);
            ArrayList<Integer> b;
            if(map.containsKey(s))//put its relative index in the HashMap
            {
                b=map.get(s);
                b.add(i+1);
                map.put(s,b);
            }
            else
            {
                b=new ArrayList<>();
                b.add(i+1);
                map.put(s,b);
            }
        }
        //Add the values of HashMap to ArrayList
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(Map.Entry<String,ArrayList<Integer>> it:map.entrySet())
        {
            ans.add(it.getValue());
        }
        
        return ans;
    }
}
