import java.math.BigInteger;

/**
 * Created by umic-lord on 2015/9/24.
 */
public class Leetcode_8 {

    public static int my_string_to_int(String str) {
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
            if(c=='-'||c=='+'){
                pn++;
                if(c=='-') {
                    neg++;
                }
                if(pn>1){
                    return 0;
                }
            }else if(nums.contains(cs)){
                num_len++;
                if(num_len>10){
                    if(neg==1){
                        return -2147483648;
                    }else {
                        return 2147483647;
                    }
                }
                if(neg==0)
                {
                    ansInt=ansInt*10+(c-'0');
                }else {
                    ansInt=ansInt*10-(c-'0');
                }
            }else {
                break;
            }
        }
        if(neg==0&&ansInt<0){
            ansInt=2147483647;
        }
        if(neg==1&&ansInt>0){
            ansInt=-2147483648;
        }
        return ansInt;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(my_string_to_int("10522545459"));

    }
}
