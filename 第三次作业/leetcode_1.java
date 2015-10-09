public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;++i){
            int key=nums[i];
            int value=i;
            if(hashMap.containsKey(target-key)){
                return new int[]{hashMap.get(target-key)+1,value+1};
            }
            hashMap.put(key,value);
        }
        return null;
    }
}