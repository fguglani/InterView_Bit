public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> a) 
    {
        //The intution behind thing is that if we have n spots then we n/2+1 numbers as same
        /*
        Lets take two examples n=6
        a={1,2,1,2,2,2}
        In this we have 2 repeating together thrice.So max_ele will become 2;
        a={1,1,2,2,2,2,}
        In this 1 will become max_ele first but will then be replaced by 2;
        a={2,2,2,2,1,1}
        In this 2's count till fourth iteration will become 4 So 1 cant replace it;
        */
        int n=a.size();
        int count=0;
        int max_ele=0;
        for(int i=0;i<n;i++)
        {
            if(count==0)
            {
                max_ele=a.get(i);
                count++;
            }
            else if(max_ele==a.get(i))
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        
        return max_ele;
    }
}
