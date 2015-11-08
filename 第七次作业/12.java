public class Solution {
    private String singleIntToRoman(int sigl, String type, String hightype) {
        String ans = "";
        switch (sigl) {
            case 4:
                ans += type + hightype;
                break;
            case 3:
                ans += type;
            case 2:
                ans += type;
            case 1:
                ans += type;
                break;
            default:
        }
        return ans;
    }

    //I=1  V=5 X=10 L=50 C=100 D=500 M=1000

    public String intToRoman(int num) {
        String ans = "";
        int thoux = num / 1000;
        ans += singleIntToRoman(thoux, "M", "");
        num %= 1000;
        if (num >= 900) {
            ans += "CM";
            num %= 100;
        } else {
            int penHud = num / 500;
            num %= 500;
            int hud = num / 100;
            num %= 100;
            ans += singleIntToRoman(penHud, "D", "") +
                    singleIntToRoman(hud, "C", "D");
        }

        if (num >= 90) {
            ans += "XC";
            num %= 10;
        } else {
            int penTen = num / 50;
            num %= 50;
            int ten = num / 10;
            num %= 10;
            ans += singleIntToRoman(penTen, "L", "C") +
                    singleIntToRoman(ten, "X", "L");
        }
        if(num>=9){
            ans+="IX";
        }else
        {
            int five = num / 5;
            num %= 5;
            int sigl = num;
            ans += singleIntToRoman(five, "V", "X") +
                    singleIntToRoman(sigl, "I", "V");
        }

        return ans;
    }

}