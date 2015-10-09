public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
//regex match
//        s=s.replaceAll("[^a-z0-9]","");
//        System.out.println(s);
//        return s.equals(new StringBuilder(s).reverse().toString());
        int left=0,right=s.length()-1;
        while (left<=right) {
            char cl = s.charAt(left);
            char cr = s.charAt(right);
            if (cl == cr) {
                left++;
                right--;
                continue;
            }
            if ((cl < '0') || (cl > '9' && cl < 'a') || (cl > 'z')) {
                left++;
                continue;
            }
            if ((cr < '0') || (cr > '9' && cr < 'a') || (cr > 'z')) {
                right--;
                continue;
            }
            return false;
        }
        return true;
    }
}