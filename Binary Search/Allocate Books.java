public class Solution {
    
    public boolean isValid(ArrayList<Integer> a,int mid,int k)
    {
        //This question is just an extension of Painter's Partition problem
        //We will be going in the very same manner
        int s=1;
        int i=0;
        int pages=0;
        while(i<a.size())
        {
            if(a.get(i)+pages<=mid)//Tp check if pages can be allocated to a particular student.
            {
                pages+=a.get(i++);//If yes allocate them
            }
            else
            {
                s++;//otherwise change the student
                pages=0;
                if(s>k)//if students needed exceed the students available then return false
                {
                    return false;
                }
            }
        }
        
        return true;
    }
    public int books(ArrayList<Integer> a, int k) 
    {
        if(a.size()<k)//if there are more students than books there is no way to allocate them
        {
            return -1;
        }
        
        int s=Integer.MAX_VALUE;
        int e=0;
        for(int i:a)
        {
            e+=i;//upper bound is sum of all pages
            s=Math.min(s,i);//lower bound is min no. of pages
        }
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(isValid(a,mid,k))//if upper bound is satisfied decrease it
            {
                e=mid-1;
            }
            else
            {
                s=mid+1;//otherwise increase the lower bound
            }
        }
        
        return s;
    }
}
