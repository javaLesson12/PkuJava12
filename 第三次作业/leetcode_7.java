public class Solution {
    public int reverse(int x) {
       String xstr=""+x;
        boolean positive=true;
        int i=0;
        if(xstr.charAt(0)=='-'){
            positive=false;
            ++i;
        }
        int len=xstr.length();
        StringBuilder stringBuilder=new StringBuilder(xstr.substring(i,len));
        int ans=0;
        try {
            ans=Integer.valueOf(stringBuilder.reverse().toString().trim());
        }
        catch (Exception e){
            return 0;
        }
        if(!positive){
            ans=0-ans;
        }
        return ans;

    }
}