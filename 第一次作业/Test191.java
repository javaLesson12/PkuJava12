class Test191 
{
	public static void main(String[] args) 
	{
		int k=int hammingWeight(68);
		System.out.println(k);
	
	
	}
    
    public static int hammingWeight(int n) 
	{
		while(n!=0)
			{
			  n=n&(n-1);
			  k++;
			}
		return k;
  
    }
}
