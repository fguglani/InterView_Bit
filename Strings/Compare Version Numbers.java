public class Solution {
    public int compareVersion(String v1, String v2) 
    {
        //Split the string at "."
        String v_1[]=v1.split("\\.");
        String v_2[]=v2.split("\\.");
        int i=0;
        int j=0;
        int n=v_1.length;
        int m=v_2.length;
        while(i<n || j<m)
        {
            int k=0;
            int l=0;
            
            if(i<n)
            {
            //Clear any leading zeros in String 1
            while(k<v_1[i].length() && v_1[i].charAt(k)=='0')
            {
                k++;
            }
            v_1[i]=v_1[i].substring(k,v_1[i].length());
            }
            
            if(j<m)
            {
            //Clear any leading zeros in String 2  
            while(l<v_2[j].length() && v_2[j].charAt(l)=='0')
            {
                l++;
            }
            v_2[j]=v_2[j].substring(l,v_2[j].length());
            
            }
            
            //Now with no leading zeros there are two possibilities 
            //1-->Length of strings not equal
            if(i<n && j<m && v_1[i].length()!=v_2[j].length())
            {
                //If length of first is more it will be a bigger version and vice versa
                if(v_1[i].length()>v_2[j].length())
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            //2-->Length of string are equal
            else if(i<n && j<m && v_1[i].length()==v_2[j].length())
            {
                k=0;
                l=0;
                //Compare char by char and if they are unequal we will get the higher version
                while(k<v_1[i].length() && l<v_2[j].length())
                {
                    char c1=v_1[i].charAt(k);
                    char c2=v_2[j].charAt(l);
                    
                    if(c1-'0'>c2-'0')
                    {
                        return 1;
                    }
                    else if(c2-'0'>c1-'0')
                    {
                        return -1;
                    }
                    //if characters are equal look for next set of characters.
                    else
                    {
                        k++;l++;
                    }
                }
                //If both strings reach end then check for other set of strings
                if(k==v_1[i].length() && l==v_2[j].length())
                {
                    i++;j++;continue;
                }
                //if v1 ends that means v2 is longer and vice versa
                else if(k==v_1[j].length())
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
            //If i ended two possibilties now
            //1-->j has only 0s left e.q __.0.0
            //2-->j has some numbers left
            else if(i==n)
            {
                if(v_2[j].equals(""))
                {
                    j++;
                }
                else
                {
                    return -1;
                }
            }
            else if(j==m)
            {
                if(v_1[i].equals(""))
                {
                    i++;
                }
                else
                {
                    return -1;
                }
            }
        }
        //If both strings end together return 0;
        
        return 0;
    }
}
