public class Solution {
 public boolean isAnagram(String s, String t) {
            char[] sChars = s.trim().toLowerCase().toCharArray();
            Arrays.sort(sChars);
            char[] tChars = t.trim().toLowerCase().toCharArray();
            Arrays.sort(tChars);
            return new String(tChars).equals(new String(sChars));

        }
}