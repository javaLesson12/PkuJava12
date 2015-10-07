public class Solution {
    public void sortColors(int[] nums) {
        int[] rgb = new int[3];

        for (int num : nums) {
            ++rgb[num];//存储颜色
        }
        int i = 0;
        for (; i < rgb[0]; ++i) {
            nums[i] = 0;
        }
        for (; i < rgb[1]+rgb[0]; ++i) {
            nums[i] = 1;
        }

        for (; i < rgb[2]+rgb[1]+rgb[0]; ++i) {
            nums[i] = 2;
        }
    }
}