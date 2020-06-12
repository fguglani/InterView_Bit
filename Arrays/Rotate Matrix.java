public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) 
    {
        int n=a.size();
        //The question is simple the implementation is a bit tricky.
        if(n==1)
        return;
        //We need to figure out which blocks will move and which will not
        /*
            1 2 3       7 4 1
            4 5 6  ---> 8 5 2  If we look carefully lets initialise two variables one l that
            7 8 9       9 6 3  moves more often and other k that moves we we need to move inside 
            So i=n-1-l     j=k      Bottom left  1
               i=k         j=l	    Top left     2
               i=l         j=n-1-k  Top right    3
               i=n-1-k     j=n-1-l  Bottom Right 4
               
               We save 2 in temp then move (temp->4->3->1->2)
        */
        for(int k=0;k<n/2;k++)
        {
            for(int l=k;l<=n-2-k;l++)
            {
            //One rota
            int temp=a.get(k).get(l);
            a.get(k).set(l,a.get(n-1-l).get(k));
            //Second rota
            a.get(n-1-l).set(k,a.get(n-1-k).get(n-1-l));
            //Third rota
            a.get(n-1-k).set(n-l-1,a.get(l).get(n-1-k));
            //Forth rota
            a.get(l).set(n-1-k,temp);
            }
        }
    }
}
