public class Solution {
        public int countPrimes(int n) {
            int ans = 0;
            if (n-1 < 2)
                return 0;
            boolean[] isPrime = new boolean[n];
            isPrime[0] = true;
            isPrime[1] = true;
            ans = n -2;
            for(int i=2;i<n;++i){
                if(isPrime[i]) continue;//¼ôÖ¦
                if(i*i>=n||i*i<0)break;//¼ôÖ¦
                for(int j =i;j*i<n;j++){
                    if(isPrime[i*j])continue;
                    if (!isPrime[i*j]){
                        isPrime[i*j] = true;
                        ans--;
                    }

                }
            }
            return ans;
        }
}