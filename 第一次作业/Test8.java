class  Test8
{
	public static void main(String[] args) 
	{
		
	}

	
    public int myAtoi(String str) {
        
        if(str==""||str==" ")
        return 0;
        char ch='+';
        String s=str.trim();
        double k=0.0;
        int i=0;
        while((i<s.length()-1)&&s.charAt(i)<'0'&&s.charAt(i)>'9'&&s.charAt(i)!='+'&&s.charAt(i)!='-')//找到有用数据
            i++;
        
        if(i<s.length()&&s.charAt(i)=='+')
        {
            ch='+';
            
            i++;
        }
            
         else if(i<s.length()&&s.charAt(i)=='-')
        {
           ch='-';
            i++; 
        }
        
        while(i<=s.length()-1&&s.charAt(i)>='0'&&s.charAt(i)<='9')
        {
            k=k*10+(s.charAt(i)-'0');
            i++;
        }
        if(ch=='-')
            k=-k;
        if(k>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(k<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
       
        return (int)k;
        
        
    }
}
