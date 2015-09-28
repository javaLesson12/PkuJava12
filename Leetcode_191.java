/**
 * Created by umic-lord on 2015/9/25.
 */
public class Leetcode_191 {
    public static void main(String[] args) throws Exception{
        int i= 2147483647;
        System.out.println(new Leetcode_191().hammingWeight(i+2));
    }
    public int hammingWeight(int n) {
        String bits=Integer.toBinaryString(n);//把n转成二进制字符串
        int ans=0;
        for(int i=0;i<32&&i<bits.length();i++){//转换为二进制int形式
            ans+=bits.charAt(i)-'0';
        }
        return ans;
    }
}
