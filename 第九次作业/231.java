public class Solution {
  public boolean isPowerOfTwo(int n) {         
     if (n == 1)                              
         return true;                         
     if (n <= 0 || n % 2 != 0)                
         return false;                        
     while (n > 1) {                          
         if (n % 2 != 0)                      
                                              
             return false;                    
         n = n >> 1;                                       
                                              
                                              
     }                                        
     return true;                             
 }                                                                                                                   
}