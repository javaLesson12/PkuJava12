/**
 * Created by umic-lord on 2015/9/25.
 */
public class Leetcode_202 {
//尝试了多个数，凡是无限循环的，这个循环数列肯定包含145。
    public boolean isHappy(int n) {
        if (n == 1) return true;//1必是
        if (n == 0) return false;//0必不是
        int on = n;
        int i=0;
        while (true) {
            int ans = 0;
            while (n > 0) {
                ans += Math.pow(n % 10, 2);//依题目进行处理
                n /= 10;
            }
            if (on == ans||ans==145) {//等于自己原本数或等于145，必是
                return false;
            } else if (ans == 1) {
                return true;
            }
            n=ans;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Leetcode_202().isHappy(7));
    }
}
