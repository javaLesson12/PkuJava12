
/*
	Single Number
	Given an array of integers, every element appears twice except for one. Find that single one.
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

import java.util.*;
class Test136 
{
	public static void main(String[] args) 
	{
		int []nums={2,4,5,2,4,6,5};
		System.out.println(singleNumber(nums)); 

	}

	public static int singleNumber(int[] nums) 
	{
		System.out.println("Arrays:"+Arrays.toString(nums));
        QuikSort(nums,0,nums.length-1);
		System.out.println("QuikSort:"+Arrays.toString(nums));
		for(int i=0;i<nums.length-1;)
		{
			if(nums[i]==nums[i+1])
			{
				i=i+2;
			    if(i==nums.length-1)
					return nums[i];
			}
		    else
				return nums[i];
		}
		return 0;
    }

	public static void QuikSort(int []nums,int p,int r)
     {
         if(p<r)
		{
			 int q= partition(nums,p,r);
			 swap(nums,p,q);
			 QuikSort(nums,p,q-1);
			 QuikSort(nums,q+1,r);
		}

     }

     public static int partition(int nums[],int p,int r)
     {
		 int x=nums[p];
		 int i=p,j=r;
		 while(i<j)
		 {
			 while(i<r&&nums[i]<=x)
				 i++;
			 while(j>p&&nums[j]>=x)
				 j--;
			 if(i<j)
			{
				swap(nums,i,j);
				i++;
				j--;
			}
		 }

         return j;
     }
    
    
    
        
    
	public  static void swap(int[]a,int i,int j)
	{
		int temp=0;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}



}
