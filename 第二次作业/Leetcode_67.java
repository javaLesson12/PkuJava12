/**
 * Created by umic-lord on 2015/9/24.
 */
public class Leetcode_67 {
    public static String addBinary(String a, String b) {
        String ans="";
        int ai=a.length()-1;
        int bi=b.length()-1;
        int cin=0;//cin表示进位
        while (ai>=0&&bi>=0){//两串，按位加
            char ac=a.charAt(ai);
            char bc=a.charAt(bi);
            int temp=ac-'0'+bc-'0'+cin;
            cin=temp/2;
            ans+=temp%2;
           // System.out.println(ans);
            --ai;
            --bi;
        }
        while (ai>=0){//a串未空
            char ac=a.charAt(ai);
            int temp=ac-'0'+cin;
            cin=temp/2;
            ans+=temp%2;
            //System.out.println(ans);
            --ai;
        }
        while (bi>=0){//b串未空
            char bc=a.charAt(bi);
            int temp=bc-'0'+cin;
            cin=temp/2;
            ans+=temp%2;
            //System.out.println(ans);
            --bi;
        }
        if (cin!=0){//进位不为0
            ans+=cin;
        }
        StringBuilder stringBuilder=new StringBuilder(ans);
        return stringBuilder.reverse().toString();
    }
    public static void main(String[] args) throws Exception{
        System.out.println(addBinary("111111","1"));
    }
}
