public class Solution {
    public int trailingZeroes(int n) {
        if(n<5) return 0;
        int ans=0;
        long k=5;
        while(n>=k)
        {
            ans+=n/k;
            k*=5;
        }
        return ans;
    }
}