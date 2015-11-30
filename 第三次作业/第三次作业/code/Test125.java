 /*
    倒着读和顺着读都一样
	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
	Note:
	Have you consider that the string might be empty? This is a good question to ask during an interview.
	For the purpose of this problem, we define empty string as valid palindrome.
 */


class Test125 
{
	public static void main(String[] args) 
	{
		String s1="A man, a plan, a canal: Panama";
		String s2="race a car";
		System.out.println("s1: "+isPalindrome(s1));
		System.out.println("s2: "+isPalindrome(s2));

	}
	 public static boolean isPalindrome(String s) 
	{
		
		 s = s.replaceAll("\\s*", "");
		 System.out.println(s);
		 s = s.toLowerCase();
		 
		 if(s==""||s==" "||s.length()==1)
		    return true;

		 for(int i=0,j=s.length()-1;i<=j;i++,j--)
		 {
			while(s.charAt(i)<'a'||s.charAt(i)>'z')
				i++;
			while(s.charAt(j)<'a'||s.charAt(j)>'z')
				j--;
			
			 if(s.charAt(i)!=s.charAt(j))
    		 return false;
			
			 
		 }
		  return true; 
    }
	
}
