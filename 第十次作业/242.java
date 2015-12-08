public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();  
        char[] tArr = t.toCharArray();  
          
        Arrays.sort(sArr);  
        Arrays.sort(tArr);  
          
        return String.valueOf(sArr).equals(String.valueOf(tArr));    
    }
}