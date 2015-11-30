class Test58 
{
	public static void main(String[] args) 
	{
		int k=lengthOfLastWord("a ");
		System.out.println(k);
	}
	public static int lengthOfLastWord(String s)
	{
			if(s==""||s==" ")
				return 0;
			String []str=s.split(" ");
			int k=str.length-1;
			while(str[k].length()==0&&k>0)
				k--;
			return str[k].length();
     }
     public static int lengthOfLastWord2(String s)
	{
			    if(s==""||s==" ")
					return 0;
				int k=0;
				int i=s.length()-1;
				while(i>0)
				{
					if(s.charAt(i)==' ')
					i--;
				}
				for(;i>=0;i--)
				{
					if(s.charAt(i)==' ')
						break;
					else
					k++;
					  
				}
				
				return k;


       }
		public static int lengthOfLastWord3(String s)
		{
			    if(s==""||s==" ")
					return 0;
				int k=0;
				int i=s.length()-1;
				while(i>0)
				{
					if(s.charAt(i)==' ')
					i--;
				}
				int j=i;
				while(j>0)
				{
				  if(s.charAt(j)!=' ')
						j--;
				}

				
				return i-j+1;


        }





}
