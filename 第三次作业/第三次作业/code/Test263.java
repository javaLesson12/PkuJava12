/*
	Ugly Number
	Write a program to check whether a given number is an ugly number.

	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

	Note that 1 is typically treated as an ugly number.

	Credits:
	Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
*/


class Test263 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
	public static boolean isUgly(int num) 
	{
		int temp;
		if(num==1)
			return true;
		if(num<1)
			return false;
		while(num%2==0)
		{
			num/=2;
		}
        while(num%3==0)
		{
			num/=3;
		}
		while(num%5==0)
		{
			num/=5;
		}
		return(num==1);

    }



}
