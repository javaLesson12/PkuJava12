public class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j=0;
        while(i<nums.length)
        {
            if(i==0)
                nums[j++]=nums[i++];
            else if(nums[j-1]==nums[i]) i++;
            else 
            {
                 nums[j++]=nums[i++];   
            }
            
        }
        return j;        
    }
}