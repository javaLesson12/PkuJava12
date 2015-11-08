public class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> romanMap = new HashMap<String, Integer>() {
            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);
                put("CM", 900);
                put("CD", 400);
                put("XC", 90);
                put("XL", 40);
                put("IX", 9);
                put("IV", 4);
            }
        };
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; ) {
            if (i + 1 < chars.length && (
                    (chars[i] == 'C' && chars[i + 1] == 'M')
                    ||(chars[i] == 'C' && chars[i + 1] == 'D')
                    || (chars[i] == 'X' && chars[i + 1] == 'C')
                    || (chars[i] == 'X' && chars[i + 1] == 'L')
                    || (chars[i] == 'I' && chars[i + 1] == 'X')
                    ||(chars[i] == 'I' && chars[i + 1] == 'V'))) {
                ans += romanMap.get(s.substring(i, i + 2));
//                out.println(ans);
                ++i;
                ++i;
            } else {
                ans += romanMap.get(s.substring(i, i + 1));
                ++i;
//                  out.println(ans);
            }
        }
        return ans;
        
    }
}