//  a="11"    b="1"  
//二进制的相加  return 1000

import java.util.*;
class  Test67
{
	public static void main(String[] args) 
	{
		String a="111";
		String b="1";
		
		//String c= addBinary(a,b);
		//System.out.println(c);

		String c1= addBinary2(a,b);
		System.out.println(c1);
	}
	public static String addBinary(String a,String b)
	{
		int aa=Integer.valueOf(a,2).intValue();
		int bb=Integer.valueOf(b,2).intValue();
		System.out.println("aa  "+aa);
		System.out.println("bb  "+bb);
		int c=aa+bb;
		return Integer.toBinaryString(c);

    }

	public static String addBinary2(String a,String b)
	{

		String sum;
		int al=a.length();
		int bl=b.length();
		int m,l;
		m=al-bl;
		if(m>0)
		{
			l=al;
			for(int i=0;i<m;i++)
			b="0"+b;
		}
		else 
		{
			l=bl;
			for(int j=0;j<-m;j++)
			a="0"+a;
		}

		System.out.println(b);

		byte[] c=new byte[l+1];
		boolean flag=false;

		for(int i=l;i>0;i--)
		{


			if(flag==true)
			{

			  if(a.charAt(i-1)+b.charAt(i-1)=='1'+'1')
			  {
				 c[i]='1';
			     flag=true;
			  }
			  
			  if(a.charAt(i-1)+b.charAt(i-1)=='1'+'0')
			  {
				 c[i]='0';
			     flag=true;
			  }
			  
			  if(a.charAt(i-1)+b.charAt(i-1)=='0'+'0')
			  {
				 c[i]='1';
			     flag=false;
			  }
			}
			else
			{
				if(a.charAt(i-1)+b.charAt(i-1)=='1'+'1')
			  {
				 c[i]='0';
			     flag=true;
			  }
			  
			  if(a.charAt(i-1)+b.charAt(i-1)=='1'+'0')
			  {
				 c[i]='1';
			     flag=false;
			  }
			  
			  if(a.charAt(i-1)+b.charAt(i-1)=='0'+'0')
			  {
				 c[i]='0';
			     flag=false;
			  }
			}


       }
        
	   if (flag==true)
	   {
		   c[0]='1';
		   sum=new String(c,0,c.length);
	   }
	   else
	   {
		   c[0]='0';
		   
		   sum=new String(c,1,c.length-1);
		}

		

		return sum;

     }


	
}



