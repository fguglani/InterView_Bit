public class Solution {
    public int romanToInt(String a) 
    {
        //The only thing to remember is we he a smaller number before a bigger number we have to subtract it
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans=0;
        int last=0;
        for(int i=0;i<a.length();i++)
        {
            int val=map.get(a.charAt(i));
            ans+=val;
            if(val>last)
            {
                ans-=2*(last);
            }
            last=val;
        }
        
        return ans;
    }
}
