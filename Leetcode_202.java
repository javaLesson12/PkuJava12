/**
 * Created by umic-lord on 2015/9/25.
 */
public class Leetcode_202 {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (n == 0) return false;
        int on = n;
        int i=0;
        while (true) {
            int ans = 0;
            while (n > 0) {
                ans += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (on == ans||ans==145) {
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
