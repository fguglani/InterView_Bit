public class Solution {
    public ArrayList<Integer> getRow(int a) 
    {
        //a starts from zero i.e. a=0 ans->{1}
        //Thr thing to consider here is just that we need to build every row from previous row.
        ArrayList<Integer> arr=new ArrayList<>();//Previous row
        ArrayList<Integer> cur=new ArrayList<>();//current row
        arr.add(1);//Row zero
        int n=1;//Lets build from row one
        while(n<=a)//Till we are one row back
        {
            for(int i=0;i<=n;i++)
            {
                int prev=0;
                int curr=0;
                //check two things
                //One is previous valid
                if(i-1>=0 && (i-1)<arr.size())
                {
                   prev=arr.get(i-1); 
                }
                //if current valid
                if(i<arr.size())
                {
                    curr=arr.get(i);
                }
                //add the valid ones to the list
                cur.add(prev+curr);
            }
            //when we reach the destination return curr list
            if(n==a)
            {
                return cur;
            }
            n++;
            arr.clear();//otherwise make curr list as previous list
            arr=(ArrayList<Integer>)cur.clone();
            cur.clear();
        }
        
        return arr;
    }
}
