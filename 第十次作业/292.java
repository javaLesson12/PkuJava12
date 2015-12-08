public class Solution {
    public boolean canWinNim(int n) {
        int val = n%4;
        if(val >= 1 && val < 4)
            return true;
        return false;    
    }
}