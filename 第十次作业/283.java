public class Solution {
    public void moveZeroes(int[] nums) {
    int i=0;  
        int j=0;  
        while(j<nums.length) {  
            if(nums[j]!=0) {  
               if(j!=i) {   
                    nums[i++] = nums[j];  
                    nums[j] = 0;  
               } else {  
                   ++i;  
               }  
            }   
            ++j;  
        }     
    }
}