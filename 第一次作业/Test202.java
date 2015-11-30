public class Test202 {

	public static void main(String[] args) 
	{
		
		System.out.println(isHappy(19));
	}

    public boolean isHappy(int n) {
       int sum; 
       int m=n;
       HashSet<Integer> Num=new HashSet();
       while(m!=1) 
       {
            if(!Num.contains(new Integer(m)))
            Num.add(new Integer(m));
            else
            return false;
            sum=0;
            while(m!=0)
            {
                sum+=(m%10)*(m%10);
                m=m/10;
            }
            m=sum;
       }
       return true;
       
       
    }
}