public class Solution {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) 
    {
        Stack<Integer> st=new Stack<>();//We will use a stack and maintain it in ascending order to to down
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=a.size()-1;i>=0;i--)
        {
            int x=a.get(i);
            if(st.isEmpty())
            {
                st.push(x);//if stack is empty that means we dont have any bigger number left in the list
                ans.add(-1);
            }
            else if(x<st.peek())
            {
                ans.add(st.peek());//if top of the stack is bigger just push it
                st.push(x);
            }
            else
            {
                while(!st.isEmpty() && x>=st.peek())//else if it is less than equal to we will remove items till we get a greater element or stack becomes empty
                {
                    st.pop();
                }
                
                if(st.isEmpty())//is stack becomes empty then there was no bigger value that was available
                {
                    ans.add(-1);
                }
                else
                {
                    ans.add(st.peek());//else just add the value at of the top
                }
                st.push(x);//then push the current element
            }
        }
        for(int i=0;i<=((ans.size()+1)/2)-1;i++)
        {
            int temp=ans.get(i);//Swap the first and last elements as we traversed list in opposite fashion
            int n_i=ans.size()-1-i;
            int word=ans.get(n_i);
            ans.set(i,word);
            ans.set(n_i,temp);
        }
        
        return ans;
    }
}
