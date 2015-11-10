public class Solution {
    public String intToRoman(int num) {
        String[][] c ={
        		{"","I","II","III","IV","V","VI","VII","VIII","IX"},
        		{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        		{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        		{"","M","MM","MMM"}};

        int tmp=num;
        String ret="";
        if(tmp/1000!=0) ret+=c[3][tmp/1000];
        if((tmp%1000)/100!=0) ret+=c[2][(tmp%1000)/100];
        if((tmp%100)/10!=0) ret+=c[1][(tmp%100)/10];
        if(tmp%10!=0) ret+=c[0][tmp%10];
        
        return ret;    
    }
}
/*
我感觉网上这个思路特别奇特，但是我没有想到更好的方法，就只能参考网上思路了。

I- 1 
II - 2 
III - 3 
IV - 4 
V - 5 
VI - 6 
VII - 7 
VIII - 8 
IX - 9 
X - 10 
XI - 11 
XII - 12 
XIII - 13 
XIV - 14 
XV - 15 
XVI - 16 
XVII - 17 
XVIII - 18 
XIX - 19 
XX - 20 
XXI - 21  
XXII - 22  
XXVIII - 28 
XXIX - 29 
XXX - 30 
XL - 40 
L - 50 
LX - 60 
LXX - 70 
LXXX - 80 
XC - 90 
XCIX - 99
C - 100 
CI - 101 
CXCIX - 199
CC - 200
CCC - 300
CD - 400
D - 500
DCLXVI - 666
M - 1,000
MCMXCIX - 1,999
MM - 2,000
MMM - 3,000 
*/