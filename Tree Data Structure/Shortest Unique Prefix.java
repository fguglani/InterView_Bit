class  trie//We will solve this question using tries
{
    char c;//char c in trie
    trie arr[];//arr to save 26 letters
    boolean isEnd;//to know if this is the end character or not
    int word;//To know many many letters are beneath us //This will help us determine if we need to iterate further or if we are at the end
    trie(char c)
    {
        this.c=c;
        arr=new trie[26];
        isEnd=false;
        word=0;
    }
}
public class Solution {
    public ArrayList<String> prefix(ArrayList<String> a) 
    {
        trie t=new trie('\0');
        for(String s:a)
        {
            trie curr=t;
            for(int i=0;i<s.length();i++)
            {
                char c=s.charAt(i);
                if(curr.arr[c-'a']==null)
                {
                    curr.arr[c-'a']=new trie(c);//Add each string character by character to the trie
                }
                curr=curr.arr[c-'a'];
                curr.word+=1;//set the count of numbers beneath us
            }
            curr.isEnd=true;
        }
        ArrayList<String> ans=new ArrayList<>();
        for(String s:a)
        {
            trie curr=t;
            StringBuilder temp=new StringBuilder();
            for(int i=0;i<s.length();i++)
            {
                char c=s.charAt(i);
                if(curr.arr[c-'a']!=null && (curr.word==1 || curr.isEnd))//if we reach end of a string or we know there are no words beneath us so this is the smallest possible prefix
                {
                    break;
                }
                temp.append(c);
                curr=curr.arr[c-'a'];
            }
            ans.add(new String(temp));
        }
        return ans;
    }
}
