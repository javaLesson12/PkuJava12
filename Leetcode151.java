public class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String ans="";
        int pos=0;
        for(int i=0;i<s.length();++i){
             if(s.charAt(i)==' ') {//遍历遇到空格，将字符串,添加到ans头部
                if (!ans.equals("")) {
                    ans = s.substring(pos, i) + " " + ans;//截取字符串，若非第一个，加空格
                } else {
                    ans = s.substring(pos, i);
                }
                while (s.charAt(++i) == ' ' && i < s.length()) ;//忽略空格后的多个空格
               
            if(i==s.length()-1){//将最后一个加入
                
                 if (!ans.equals("")) {
                   ans=s.substring(pos,s.length())+" "+ans;
                } else {
                    ans=s.substring(pos,s.length());
                }
            }
        }
        
        return ans;
    }
}