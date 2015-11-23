public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len=1;
        int currentVal=nums[0];
        int pos = 1;
        for(int i=1;i<nums.length;++i){
            if (nums[i]!=currentVal){
                len++;
                currentVal = nums[i];
                nums[pos++] = nums[i];
            }
        }
        return len;
    }
}