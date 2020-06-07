public class Solution {
    public boolean isValid(int a,int m,ArrayList<Integer> c)
    {
        //we need to check for particular count generated through binary search how many painters are needed?
        int painter=1;
        int paint=0;
        int i=0;
        while(i<c.size())
        {
            if(paint+c.get(i)<=m)//calculate if we can assign particular board to the painter
            {
                paint+=c.get(i++);//if yes add to the value
            }
            else
            {
                paint=0;
                painter++;//else assign it to other painter
                if(a<painter)//if painter count crosses the painters we have available 
                return false;//then the count ain't valid
                
            }
        }
        
        return true;//otherwise its valid
        
    }   
    
    public int paint(int a, int b, ArrayList<Integer> c) 
    {
        /*
        As we can choose only continuous entities so we can use binary search as sum will be contiguous 
        */
        int n=c.size();
        int s=Integer.MAX_VALUE;
        int sum=0;  
        for(int i:c)
        {
            sum+=i;
            s=Math.min(s,i);//the lowest point will be the smallest value of the array
        }
        int e=sum;//whereas the largest point will be the sum of array
        int mod=10000003;
        while(s<=e)
        {
            int mid=(s+e)/2;//we will try to find the optimum count so that it takes minimum time
            if(isValid(a,mid,c))
            {
                e=mid-1;//if we find the upper bound try to reduce it as much as possible
            }
            else
            {
                s=mid+1;//otherwise increase the lower bound
            }
        }
        long ans=((long)s*(long)b);
        return (int)(ans%mod);
    }
}
