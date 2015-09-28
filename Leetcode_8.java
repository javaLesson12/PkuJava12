import java.math.BigInteger;

/**
 * Created by umic-lord on 2015/9/24.
 */
public class Leetcode_8 {

    public static int my_string_to_int(String str) {
        //这题提交很多次
        str = str.trim();
        if(str.length()==0)return 0;
        int i = 0;
        int neg = 0;
        int pn = 0;
        String nums="0123456789";
        int num_len=0;
        int len = str.length();
        int ansInt=0;
        for(;i<len; ++i){
            char c=str.charAt(i);
            String cs=str.substring(i,i+1);
            if(c=='-'||c=='+'){//统计正负号
                pn++;
                if(c=='-') {
                    neg++;//统计负号
                }
                if(pn>1){//符号多于一个，则无效字符，直接返回0
                    return 0;
                }
            }else if(nums.contains(cs)){
                num_len++;
                if(num_len>10){//字符长度大于10位，溢出，根据符号，返回最大和最小值
                    if(neg==1){
                        return -2147483648;
                    }else {
                        return 2147483647;
                    }
                }
                if(neg==0)//判断符号
                {
                    ansInt=ansInt*10+(c-'0');//正号加
                }else {
                    ansInt=ansInt*10-(c-'0');//负号减
                }
            }else {
                break;//出现"+ - [0-9]"以外的数，停止遍历
            }
        }
        if(neg==0&&ansInt<0){//符号为正，结果为负，溢出取最大值
            ansInt=2147483647;
        }
        if(neg==1&&ansInt>0){//符号为负，结果为正，溢出取最小值
            ansInt=-2147483648;
        }
        return ansInt;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(my_string_to_int("10522545459"));

    }
}
