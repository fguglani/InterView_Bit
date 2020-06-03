public class Solution {
    //Idea here is very simple that the closer the mouse better to put it in the closest hole.
    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) 
    {
        Collections.sort(a);
        Collections.sort(b);
	//Sort both arrays and check which mouse needs to travel the farthest.
        int max=0;
        for(int i=0;i<a.size();i++)
        {
            max=Math.max(max,Math.abs(a.get(i)-b.get(i)));
        }
        
        return max;
    }
}
