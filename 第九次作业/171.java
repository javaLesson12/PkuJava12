public class Solution {
    public int titleToNumber(String s) {
        s=s.trim().toUpperCase();
        if (s.equals(""))
            return 0;
        char[] chars = s.toCharArray();
        int ans = 0;
        int len = chars.length-1;
        int times = 1;
        for (int i=0;i<chars.length;++i){
            ans+=(chars[len-i]-'A'+1)*times;
            times*=26;
        }
        return ans;
    }
}