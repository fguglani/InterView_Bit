public class Solution {
    public String convertToTitle(int a) 
    {
        //This is a easy question with a slight trick trick is when a%26==0
        /*
        Lets us take into consideration two examples and try to see what things we should be adding in our code
        a=26 so a%26==0 so ('A'+(z-1))-->will give us '@' so when we hit such condition we should add (1)
        Now take example of a=676 so a%26==0 we add a 'Z' now a/26=26 we should again add a 'Z'???
        Ans is NO .We actually need to do a slight modification i.e. when a%26==0 then a=(a/26)-1
        Seems weird right
        Lets try to form an intuition over this
        First 26 letter are A-Z
        Then next 26 are AA-AZ
        So we have 26(single digits) + [for double digits]{26(Letters that index 0 can have)*26 (Letters that index 1 can have)}
        So now total numbers possible till two digits are-->702
        So last series will be-->ZA-ZZ that will be from 677 to 702
        So 676 no. for our answer will be 'YZ'
        */
        String ans="";
        while(a>0)
        {
            int z=a%26;
            if(z==0)
            {
                a=(a/26)-1;
                ans=""+'Z'+ans;//(1)
            }
            else
            {
            a/=26;
            ans=""+((char)('A'+z-1))+ans;
            }
        }
        
        return ans;
    }
}
