public class Solution {
    public int isPower(int n) 
    {
        //This problem is based on logarithms
        if(n==1)
        {
            return 1;
        }
        
        for(int i=2;i<=(int)Math.sqrt(n);i++)
        {
            //We will take log of the number with the try to find its base iterating over i
            double val=(double)Math.log(n)/(double)Math.log(i);
            //Java does not calculate exact values every time so we will take some error 10^-8
            if((val - (int) val) < 0.00000001)
            {
                return 1;
            }
        }
        
        return 0;
    }
}
