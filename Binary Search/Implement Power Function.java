public class Solution {
    public int pow(int x, int n, int d) 
    {
        //In this question we need to know the concept and then take care of numbers not exceeding max value of a particular datatype
        //We can use property of modulus i.e ((a%d)*(b%d))%d==(a*b)%d
        //e.g. let a=8 b=9 and d=5 so ((8%5)*(9%5))%5=(12%5)=2 and (8*9)%5=(72%5)=2 
        if(n==0 && x==0)
        {
            return 0;//So if base is 0 then answer will always be zero
        }
        else if(n==0)
        {
            return 1;//if base is not zero value will be 1
        }
        
        long temp=pow(x,n/2,d);//calculating the two halves of the result.
        temp%=d;//taking its mod
        if(n%2==0)
        {
            return (int)(((long)temp*(long)temp)%(long)d);//if n%2==0 so just multiply as both are equal
        }
        else
        {
            long mult=((((long)x*(long)temp)%d)*(long)temp);//we need to multiply one base also
            long ans=mult%d;
            if(ans<0)//if ans comes to be negative
            {
                ans=Math.abs(ans)%d;//Java does not handle negative modulus
                ans=d-ans;
            }
            return (int)(ans);//Return ans
        }
    }
}
