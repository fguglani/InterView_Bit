class com implements Comparator<String>
{
    //Another different one of its type question 
    //The only trick is it is difficult to predict by seeing numbers when they combine what will be the best
    //So its best to design compare in such a way that it combines number and check
    public int compare(String s1,String s2)
    {
        String x=s1+s2;
        String y=s2+s1;
        if(Long.parseLong(x)>Long.parseLong(y))
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}

public class Solution 
{
    public String largestNumber(final List<Integer> a) 
    {
        ArrayList<String> s=new ArrayList<>();
        for(int i:a)
        {
            s.add(Integer.toString(i));
        }
        Collections.sort(s,new com());
        StringBuilder ans=new StringBuilder();//For Java Kids dont use String instead use StringBUilder --->Strings will lead to TLE
        for(int i=0;i<s.size();i++)
        {
            ans.append(s.get(i));
        }
        
        if(ans.charAt(0)=='0')
        return "0";
        return new String(ans);
    }
}
