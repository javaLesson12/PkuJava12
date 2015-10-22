public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
		a = sb.reverse().toString();
		b = new StringBuilder(b).reverse().toString();		
		char[] a_arr = a.toCharArray();
		char[] b_arr = b.toCharArray();
		char[] c_arr = new char[Math.max(a_arr.length, b_arr.length)+1];
		int carry=0;
		int i=0;
		while(i<a_arr.length && i<b_arr.length)
		{
			if(a_arr[i]=='0' && b_arr[i]=='0' && carry==0)
			{
				c_arr[i]='0';
				carry=0;sb = new StringBuilder(a);
			}
			else if(a_arr[i]=='0' && b_arr[i]=='1' && carry==0)
			{
				c_arr[i]='1';
				carry=0;
			}
			else if(a_arr[i]=='1' && b_arr[i]=='0' && carry==0)
			{
				c_arr[i]='1';
				carry=0;
			}
			else if(a_arr[i]=='1' && b_arr[i]=='1' && carry==0)
			{
				c_arr[i]='0';
				carry=1;
			}
			else if(a_arr[i]=='0' && b_arr[i]=='0' && carry==1)
			{
				c_arr[i]='1';
				carry=0;
			}
			else if(a_arr[i]=='0' && b_arr[i]=='1' && carry==1)
			{
				c_arr[i]='0';
				carry=1;
			}
			else if(a_arr[i]=='1' && b_arr[i]=='0' && carry==1)
			{
				c_arr[i]='0';
				carry=1;
			}
			else if(a_arr[i]=='1' && b_arr[i]=='1' && carry==1)
			{
				c_arr[i]='1';
				carry=1;
			}
			i++;
		}
		if(i<a_arr.length)
		{
			while(i<a_arr.length)
			{
				if(a_arr[i]=='0' && carry==0)
				{
					c_arr[i]='0';
					carry=0;
				}
				else if(a_arr[i]=='0' && carry==1)
				{
					c_arr[i]='1';
					carry=0;
				}
				else if(a_arr[i]=='1' && carry==0)
				{
					c_arr[i]='1';
					carry=0;
				}
				else if(a_arr[i]=='1' && carry==1)
				{
					c_arr[i]='0';
					carry=1;
				}
				i++;
			}
			if(carry==1)
				c_arr[i]='1';
		}
		else if(i<b_arr.length)
		{
			while(i<b_arr.length)
			{
				if(b_arr[i]=='0' && carry==0)
				{
					c_arr[i]='0';
					carry=0;
				}
				else if(b_arr[i]=='0' && carry==1)
				{
					c_arr[i]='1';
					carry=0;
				}
				else if(b_arr[i]=='1' && carry==0)
				{
					c_arr[i]='1';
					carry=0;
				}
				else if(b_arr[i]=='1' && carry==1)
				{
					c_arr[i]='0';
					carry=1;
				}
				i++;
			}
			if(carry==1)
				c_arr[i]='1';
		}
		else if(carry==1)
			c_arr[i]='1';

		return new StringBuilder(new String(c_arr)).reverse().toString().trim();
    }
}