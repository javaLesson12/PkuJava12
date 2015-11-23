public class Solution {
    public boolean containsDuplicate(int[] nums) {
         HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums){
            int len= hashSet.size();
            hashSet.add(i);
            if (len == hashSet.size()){
                return true;
            }
        }
        return false;
    }
}