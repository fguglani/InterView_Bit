public class Solution 
{
    //I used backtracking but this can be done parallely using bitmasks also
    ArrayList<ArrayList<String>> ans;
    //Declare the ans list
    
    void add(int mat[][],int n)//Functions adds the configuration when we achieve placing all n queens
    {
        ArrayList<String> t=new ArrayList<>();
            for(int k=0;k<n;k++)
            {
                String temp="";
                for(int l=0;l<n;l++)
                {
                    if(mat[k][l]==1)
                    {
                        temp+="Q";
                    }
                    else
                    {
                        temp+=".";
                    }
                }
                t.add(temp);
            }
            ans.add(t);
    }
    //Function to check if we can place the queen
    public boolean isValid(int mat[][],int i,int j,int n)
    {
        //As we go in row wise manner we dont need to check in the row
        
        
        //We check along all the columns in that row
        for(int k=0;k<n;k++)
        {
            if(mat[k][j]==1)
            return false;
        }
        
        int r=i;
        int c=j;
        
        //we check in the left diagonal
        while((--r)>=0 && --c>=0)
        {
            if(mat[r][c]==1)
            return false;
        }
        
        r=i;
        c=j;
        
        //we check in the right diagonal
        while(--r>=0 && ++c<n)
        {
            if(mat[r][c]==1)
            return false;
        }
        
        return true;
        
    }
    
    public void solve(int mat[][],int i,int n)
    {
        if(i==n)//if we reach the last row i.e we have successfully placed all queens at their positions
        {
            add();
            return;
        }
        
    for(int j=0;j<n;j++)//iterating over each column in the row to check the place where a queen can be kept
    {
        if(isValid(mat,i,j,n))
            {
                mat[i][j]=1;//placing the queen
                solve(mat,i+1,n);
                mat[i][j]=0;//backtracking to remove it
            }
        }
    }
    
    public ArrayList<ArrayList<String>> solveNQueens(int n) 
    {
        int mat[][]=new int[n][n];
        ans=new ArrayList<>();
        solve(mat,0,n);
        return ans;
    }
}
