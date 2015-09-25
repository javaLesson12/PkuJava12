import java.util.Arrays;

/**
 * Created by umic-lord on 2015/9/25.
 */
public class Leetcode_75 {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
    public static void main(String[] args) throws Exception{
        int[] nums =new int[]{0,1,2,0,1,0,2,0,1};

        Leetcode_75 l_75=new Leetcode_75();
        l_75.sortColors(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
