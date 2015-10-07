/**
 * Created by umic-lord on 2015/9/25.
 */
public class Leetcode_58 {
    public static int lengthOfLastWord(String s) {
        int pos=s.length();
        for(int i=s.length()-1;i>=0;--i){//尾部遍历，出现空格就可求长度
            if(s.charAt(i)==' '){
                pos=s.length()-1-i;
                break;
            }
        }
        return pos;
    }
    public static void main(String[] args) throws Exception{
        System.out.println(lengthOfLastWord("Hello wor ld"));
    }
}
