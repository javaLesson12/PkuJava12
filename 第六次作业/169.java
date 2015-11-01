public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1)
        return nums[0];
        
        int count =1;
        int major =nums[0];
        for(int i=1;i<=nums.length-1;i++){
            if (nums[i]==major)    
                count++;
            else {
                if (count==0){
                    count++;
                    major =nums[i];
                   
                }else  count--;
                
            }
        }
        return major; 
    }
}