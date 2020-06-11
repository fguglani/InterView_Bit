public class Solution {
    public int firstMissingPositive(ArrayList<Integer> a) 
    {
        //This is a simple question when we have to use linear space but with constant space more than a bit tricky
        //This is divided into two parts
        //1)->If there is a 1 in the arr
        //2)->If there is no 1 in the arr...If there is no one then ans=1
        //If there is a one we know that ans is something else than 1 so we make all negatives zero and numbers greater than size of arr as 1
        //Then we start negating absolute of (number-1)
        //Now two conditions are possible some numbers from 0---(n-1) is postive then answer is number+1 because we must have seen that number if it is not negative
        //Else all are negative that means we have a series from 1--n then answer is n+1;
        int n=a.size();
        int flag=0;
        for(int i=0;i<n;i++)
        {
           if(a.get(i)==1)
           {
               flag=1;
           }
        }
        if(flag!=1)
        return 1;
        else
        {
            for(int i=0;i<n;i++)
            {
                if(a.get(i)<=0 || a.get(i)>n)
                {
                    a.set(i,1);
                }
            }
            
            for(int i=0;i<n;i++)
            {
                int x=Math.abs(a.get(i))-1;
                a.set(x,-1*(Math.abs(a.get(x))));
            }
            for(int i=0;i<n;i++)
            {
                if(a.get(i)>0)
                {
                    return i+1;
                }
            }
            
        }
        
        return n+1;
    }
}
