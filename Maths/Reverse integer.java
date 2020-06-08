public class Solution {
    public int reverse(int a) 
    {
        //The only catch here is we can not reverse a negative number directly
        //First check if it is negative or not
        //Then take its mod
        //Reverse the number you can either use long to store the reversed number or try catch to check if number overflows or not
        //If number was originally negative deliever it with a negative sign
        int neg=0;
        long res=0;
        if(a<0)
        {
            neg=1;
        }
        a=Math.abs(a);
        while(a>0)
        {
            res*=10;
            res+=(a%10);
            a/=10;
        }
        if(res>Integer.MAX_VALUE)
        {
            return 0;
        }
        else if(neg==1)
        {
            return (int)(-1*res);
        }
        
        return (int)res;
    }
}
	