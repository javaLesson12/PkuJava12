
import java.util.*;
class Test1 
{
	public static void main(String[] args) 
	{
		int a[]={2, 7, 11, 15};
		int []index=twoSum(a,9);
		System.out.println(Arrays.toString(index));

	}
	
    public static int[] twoSum(int[] nums, int target) 
    {
        int temp;
        int[]index=new int[2] ;
        
        for(int i=0;i<nums.length;i++)
        {
            temp=target-nums[i];
            for(int j=i+1;j<nums.length;j++)
				if(nums[j]==temp)
				{
					index[0]=i;
					index[1]=j;
				}
        }
		return index;
        
    }

}
