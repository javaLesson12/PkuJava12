public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (hashSet.contains(nums[i])) {
                ans -= nums[i];
            } else {
                hashSet.add(nums[i]);
                ans += nums[i];
            }
        }
        return ans;
    }
}