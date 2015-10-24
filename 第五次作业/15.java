public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
                Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            int rs = nums[i];
            int high = nums.length - 1;
            int low = i + 1;
            while (low < high) {
                if (nums[low] + nums[high] + rs > 0) {
                    high--;
                } else if (nums[low] + nums[high] + rs < 0) {
                    low++;
                } else {
                    List<Integer> input = new ArrayList<>();
                    input.add(nums[i]);
                    input.add(nums[low]);
                    input.add(nums[high]);
                    ans.add(input);
                    int obj = nums[low++];
                    while (low < nums.length && obj == nums[low]) {
                        low++;
                    }
                    obj = nums[high--];
                    while (high >= 0 && obj == nums[high]) {
                        high--;
                    }
//                    System.out.println(low + " " + high);
                    if (low > high) break;
                }
            }
            int obj = nums[i];
            boolean fix=false;
            while (i < nums.length - 2 && nums[i] <= 0 && nums[i] == obj) {
                ++i;
                fix=true;
            }
            if(fix){
                --i;
            }
            
        }
        return ans;
    }
}