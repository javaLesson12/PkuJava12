public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> dic=new HashMap<Integer,Integer>();
        for(int n:nums)
        {
            if(dic.containsKey(n))
            {
                return true;
            }
            dic.put(n,1);
        }
        return false;
    }
}