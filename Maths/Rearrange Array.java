public class Solution {
    public void arrange(ArrayList<Integer> a) 
    {
        //The question here looks tough because it is a idea we should always think when we get range 0-n-1
        //Lets take one example and understand this
        //arr=[4,0,2,1,3]
        //first iteration-->arr(0)=4-->arr(4)=3 So we have to put 3 at index 0 So lets do (3%5)*5+4=19--->if we want new val 19/5==3 and if we want old val 19%5==4
        int n=a.size()+1;
        for(int i=0;i<a.size();i++)
        {
            
            a.set(i,a.get(i)+((a.get(a.get(i)))%n)*n);
        }
        
        for(int i=0;i<a.size();i++)
        {
            a.set(i,a.get(i)/n);
        }
    }
}
