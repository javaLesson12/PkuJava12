public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(nums.length<4) 
            return ans;
        Set<List<Integer>> set=new HashSet<List<Integer>>();
        int sum;
        HashMap<Integer,List<Integer>> h=new HashMap<Integer,List<Integer>>();
        Integer[] cac=new Integer[4];
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                sum=nums[i]+nums[j];
                if(h.containsKey(target-sum))
                {
                    List<Integer> p=h.get(target-sum);
                    for(int k=0;k<p.size()-1;k+=2)
                    {
                        if(p.get(k)==i || p.get(k+1)==i || p.get(k+1)==j) continue;
                        cac[0]=nums[i];
                        cac[1]=nums[j];
                        cac[2]=nums[p.get(k)];
                        cac[3]=nums[p.get(k+1)];
                        Arrays.sort(cac);
                        List<Integer> input=new ArrayList<Integer>();
                        for(Integer num:cac)
                        {
                            input.add(num);
                        }
                        set.add(input);
                        
                    }
                }
                if(!h.containsKey(sum))
                {
                    List<Integer> t=new ArrayList<Integer>();
                    t.add(i);t.add(j);
                    h.put(sum,t);
                }
                else
                {
                    h.get(sum).add(i);h.get(sum).add(j);
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