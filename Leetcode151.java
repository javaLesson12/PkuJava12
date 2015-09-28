import java.util.ArrayList;

/**
 * Created by umic-lord on 2015/9/25.
 */
public class Leetcode151 {
    public String reverseWords(String s) {
        s=s.trim();
        String ans="";
//        ArrayList<String> strs=new ArrayList<>();
//        String word;
//        int pos=0;
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)==' '&&pos<i){
//                strs.add(s.substring(pos,i));
//                while (s.charAt(++i)==' ');
//                pos=i;
//            }
//            if(i==s.length()-1){
//                strs.add(s.substring(pos,i+1));
//            }
//        }
//        int len=strs.size()-1;
//        for(int i=len;i>=0;--i){
//            ans+=strs.get(i);
//            if(i>0){
//                ans+=" ";
//            }
//        }
// -------------------------------------
//        String[] rs=s.split(" ");
//
//        for(int i=rs.length-1;i>=0;--i){
//            String add=rs[i].trim();
//            ans+=rs[i].trim();
//            if(i>0&&!add.equals("")){
//               ans+=" ";
//          }
//        }
// --------------------------------------
        int pos=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)==' ') {//遍历遇到空格，将字符串,添加到ans头部
                if (!ans.equals("")) {
                    ans = s.substring(pos, i) + " " + ans;//截取字符串，若非第一个，加空格
                } else {
                    ans = s.substring(pos, i);
                }
                while (s.charAt(++i) == ' ' && i < s.length()) ;//忽略空格后的多个空格
                pos = i;
            }
            if(i==s.length()-1){
                ans=s.substring(pos,s.length())+" "+ans;//将最后一个加入
            }
        }
        return ans.trim();
    }
    public static void main(String[] args) throws Exception{
        System.out.println(new Leetcode151().reverseWords("b      a"));
    }
}
