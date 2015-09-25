import java.util.ArrayList;
import java.util.List;

/**
 * Created by umic-lord on 2015/9/25.
 */
public class Leetcode_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows==0) return ans;
        ArrayList<Integer> add_array = new ArrayList<>();
        add_array.add(1);
        ans.add(add_array);
        --numRows;
        int len = 2;
        while (numRows > 0) {
            ArrayList<Integer> pre = (ArrayList<Integer>) ans.get(len - 2);
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < len; ++i) {
                int l, r;
                if (i - 1 < 0) {
                    l = 0;
                } else {
                    l = pre.get(i - 1);
                }
                if (i == pre.size()) {
                    r = 0;
                } else {
                    r = pre.get(i);
                }
                arrayList.add(l + r);

            }
            ans.add(arrayList);
            --numRows;
            ++len;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Leetcode_118 l = new Leetcode_118();
        List<List<Integer>> arrayLists = l.generate(5);
        for (List<Integer> list : arrayLists) {
            for (int i : list) {
                System.out.print(i);

            }
            System.out.println();
        }
    }
}
