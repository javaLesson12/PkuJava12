
/*
	Remove Element
	Given an array and a value, remove all instances of that value in place and return the new length.

	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/


class Test27 
{
	public static void main(String[] args) 
	{
		int []nums={4,7,8,2,4,2,3,4,6,4};
		System.out.println( removeElement(nums, 4));
		
	}

	 public static int removeElement(int[] nums, int val) 
	{
		int len=nums.length;
		int j=len-1;
        for(int i=0;i<nums.length;i++)
		{
			if(i>j)
			break;
			if(nums[i]==val)
			{
				nums[i]=nums[j];
				j--;
				len--;
				i--;
			}
		}
		return len;
    }
}
