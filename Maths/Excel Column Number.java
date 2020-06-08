public class Solution {
    public int titleToNumber(String a) 
    {
        //Everytime we get (i+1)th index the place value of last index increases
        //It same as place values only catch is this is 26 digits number system
        //So steps will be
        //Multiply (i-1)th sum with 26
        //Add ith number 
        //Repeat till length of string
        int ans=0;
        for(int i=0;i<a.length();i++)
        {
            ans*=26;
            int c=a.charAt(i)+1-'A';
            ans+=c;
        }
        
        return ans;
    }
}
