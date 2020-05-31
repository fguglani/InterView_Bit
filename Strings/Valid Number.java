public class Solution {
    public int isNumber(final String b) 
    {
        int d=0;//count number of decimals-->only 1 allowed
        int e=0;//count number of exponents-->only 1 allowed
        int n=b.length();
        String a=b.replaceAll(" ","");//trim down all the white spaces
        n=a.length();
        if(n==0)
        {
            return 0;
        }
        for(int i=0;i<n;i++)
        {
            char c=a.charAt(i);
            //characters allowed are +,-,.,e and 0-9 else everything is false
            if(c=='.' || c=='e' || c=='+' || c=='-' || (c>='0' && c<='9'))
            {
                if(c=='.')//Cases with decimals
                {
                    d++;
                    if(d>=1 && e>=1)//if we have e before decimal then number is not valid
                    {
                        return 0;
                    }
                    else if(d==1 && (i+1<n && a.charAt(i+1)>='0' && a.charAt(i+1)<='9'))
                    {
                        i++;//Making sure we have a a number after decimal
                        continue;
                    }
                    else
                    {
                        return 0;//all other scenarios are false for decimal
                    }
                }
                else if(c=='e')
                {
                    e++;//counting exponents
                    if(i-1>=0 && i+1<n && e<2 || (a.charAt(i-1)-'0'>=0 && a.charAt(i-1)-'0'<=9) || a.charAt(i+1)=='+' || a.charAt(i+1)=='-')
                    {
                        i++;//exponents can have prefix as 0-9 only but can have suffix as 0-9,+ and -.
                        continue;
                    }
                    else//all other scenarios are false for exponents.
                    {
                        return 0;
                    }
                }
                else if(c=='+' || c=='-')//+ and - have to be followed by numeric number
                {
                    if(i+1<n && ((a.charAt(i+1)-'0'>=0 && a.charAt(i+1)-'0'<=9) || a.charAt(i+1)=='.'))
                    {
                        i++;
                    }
                    else
                    {
                        return 0;//all other scenarios are false for numbers.
                    }
                }
            }
            else//rest any other digit is false.
            {
                return 0;
            }
        }
        //if all goes well we have a valid number.
        return 1;
    }
}
