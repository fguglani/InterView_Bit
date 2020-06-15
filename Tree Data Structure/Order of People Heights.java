//Without using tree
//We will use the idea that if we fix the tallest person first then it wont be affected by others in the queue
//Similarly for (i)th tallest person it wont be affected by (n-i) people in queue
//So sort according to heights in descending order.
class Pair
{
    int i;
    int j;
    Pair(int i,int j)
    {
        this.i=i;
        this.j=j;
    }
}
class com implements Comparator<Pair>
{
    public int compare(Pair p1,Pair p2)
    {
        if(p1.i!=p2.i)
        {
            return p2.i-p1.i;
        }
        else
        {
            return p1.j-p2.j;
        }
    }
}

public class Solution {
    public ArrayList<Integer> order(ArrayList<Integer> a, ArrayList<Integer> b) 
    {
        ArrayList<Pair> p=new ArrayList<>();
        for(int i=0;i<a.size();i++)
        {
            p.add(new Pair(a.get(i),b.get(i)));
        }
        Collections.sort(p,new com());
        //After sorting just put the people at their correct position
        ArrayList<Integer> ans=new ArrayList<>();
        for(Pair i:p)
        {
            ans.add(i.j,i.i);
        }
        return ans;
    }
}
