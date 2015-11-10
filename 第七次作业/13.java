public class Solution {
    public int romanToInt(String s) {
    String[][] c={
    		{"0","I","II","III","IV","V","VI","VII","VIII","IX"},
    		{"0","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
    		{"0","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
    		{"0","M","MM","MMM"}};
    int num=0,i;
    for(i=0;i<s.length();i++)
    {
        if(s.charAt(i)=='I') num+=1;
        if(s.charAt(i)=='V')
        {
           if(i!=0 && s.charAt(i-1)=='I') num+=3;
           else num+=5;
        }
        if(s.charAt(i)=='X')
        {
            if(i!=0 && s.charAt(i-1)=='I') num+=8;
            else num+=10;
        }
        if(s.charAt(i)=='L')
        {
            if(i!=0 && s.charAt(i-1)=='X') num+=30;
            else num+=50;
        }
        if(s.charAt(i)=='C')
        {
            if(i!=0 && s.charAt(i-1)=='X') num+=80;
            else num+=100;
        }
        if(s.charAt(i)=='D')
        {
            if(i!=0 && s.charAt(i-1)=='C') num+=300;
            else num+=500;
        }
        if(s.charAt(i)=='M') 
        {
            if(i!=0 && s.charAt(i-1)=='C') num+=800;
            else num+=1000;
        }
    }
    return num;    
    }
}