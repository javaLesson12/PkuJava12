public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int[] nums1Tmp = Arrays.copyOf(nums1, m);
            int pos1 = 0, pos2 = 0;
            for (int i = 0; i < m + n; ++i) {
                if ((pos1 < m && pos2 < n && nums1Tmp[pos1] <= nums2[pos2]) || (pos2 == n && pos1 < m)) {
                    nums1[i] = nums1Tmp[pos1++];
                } else if ((pos1 < m && pos2 < n) || (pos1 == m && pos2 < n)) {
                    nums1[i] = nums2[pos2++];
                }
            }

    }
}