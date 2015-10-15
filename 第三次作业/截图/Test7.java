/*
	Reverse digits of an integer.
	Example1: x = 123, return 321
	Example2: x = -123, return -321
*/


class Test7 
{
	public static void main(String[] args) 
	{
		System.out.println(reverse(-123));
		System.out.println(reverse(123));
		System.out.println(reverse(1534236469));

	}
	public static  int reverse(int x)
    {
		boolean flag=true ; 
		long sum=0;

		if(x<0)
		{
			flag=false;
			x=-x;
		}
		
		while(x!=0)
		{
			sum=10*sum+(x%10);
			x=x/10;
		}

		if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE) //这句话忘记写了就报错，为啥？怕反过来的数超过了int的表示范围
			return 0;
		if(flag==false)
			sum=-sum;
		return (int)sum;


        
    }

}
