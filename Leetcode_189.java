import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by umic-lord on 2015/9/25.
 */
public class Leetcode_189 {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
//        int[] temp=new int[k];
//        int t=0;
//        for (int i = nums.length - k; i < nums.length; ++i,++t) {
//            temp[t]=nums[i];
//        }
//        for(int i=nums.length-1;i>=k;--i){
//            nums[i]=nums[i-k];
//        }
//        for(int i=0;i<k;++i){
//            nums[i]=temp[i];
//        }
        int len=nums.length;
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
        for(int i=0;i<len;++i){
            if(i<len-k) {
                a1.add(nums[i]);
            }else {
                a2.add(nums[i]);
            }
        }
        a2.addAll(a1);
        for(int i=0;i<a2.size();++i){
            nums[i]=a2.get(i);
        }
    }

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        for (int i : nums) {
            System.out.println(i);
        }

    }
}
