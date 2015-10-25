public class Solution {
    public boolean isUgly(int num) {
        if ( num<=0){
            return false;
        }
        
        while( (num%2==0)||(num%3==0)||(num%5==0)){
            if( num%2==0)       num/=2;
            if( num%3==0)       num/=3;
            if( num%5==0)       num/=5;
            
        }
        return num==1;                //经过while循环后结果若等于1为true，否则，结果为false；
    }
}