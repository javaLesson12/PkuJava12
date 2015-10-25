public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(nums.length<3) 
            return ans;
        Set<List<Integer>> set=new HashSet<List<Integer>>();
        int i,j,k;
        for(i=0;i<nums.length-2;i++)
        {
            j=i+1;
            k=nums.length-1;
            while(j<k)
            {
                if((nums[i]+nums[j]+nums[k])>0)
                    k--;
                if((nums[i]+nums[j]+nums[k])<0)
                    j--;    
                if((nums[i]+nums[j]+nums[k])==0)
                {
                    List<Integer> input=new ArrayList();
                    input.add(nums[i]);
                    input.add(nums[j]);
                    input.add(nums[k]);
                    set.add(input);
                    j++;k--;
                }
                else if((nums[i]+nums[j]+nums[k])<0)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        for(List<Integer> s:set)
        {
            ans.add(s);
        }
        return ans;
    }
}