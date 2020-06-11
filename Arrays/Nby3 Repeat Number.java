public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) 
    {
        //This is an extension of Moorie's Voting Algorithm
        //Instead of keeping one we keep two numbers now
        //Lets try to build the intuition behind this
        //Let an array be 1 2 3 2 4-->Intuition behind Moorie algo is if number is more than n/2 times it will come consequent some where or the other
        //First Iteration:-Third condition is true so count1=1 and first=1
        //Second Iteration:-Forth condition is true so count2=1 and second=2
        //Third Iteartion:-5 is true:-count1==0 and count2==0
        //Forth Iteration:-Third condition is true so count1=1 and first=1
        //Fifth Iteartion:-Forth condition is true so count2=1 and second=2
        //After this verify if first or second is repeated n/3 times or not
        //Return the suitable result
        int count1=0;
        int count2=0;
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        
        for(int i=0;i<a.size();i++)
        {
            if(first==a.get(i))//(1)
            {
                count1++;
            }
            else if(second==a.get(i))//(2)
            {
                count2++;
            }
            else if(count1==0)//(3)
            {
                count1++;
                first=a.get(i);
            }
            else if(count2==0)//(4)
            {
                count2++;
                second=a.get(i);
            }
            else//(5)
            {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i)==first)
            {
                count1++;
            }
            else if(a.get(i)==second)
            {
                count2++;
            }
        }
        
        if(count1>(a.size()/3))return first;
        else if(count2>(a.size()/3))return second;
        else return -1;
    }
}
