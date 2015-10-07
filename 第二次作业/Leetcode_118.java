import java.util.ArrayList;
import java.util.List;

/**
 * Created by umic-lord on 2015/9/25.
 */
//     1
//    1 1 
//   1 2 1
//  1 3 3 1
// 1 4 6 4 1
//1 5 10 10 5 1
public class Leetcode_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows==0) return ans;//若要求返回行为0，返回空List
        ArrayList<Integer> add_array = new ArrayList<>();
        add_array.add(1);
        ans.add(add_array);//List中加入第一行
        --numRows;//剩余行减1
        int len = 2;//第二行的数字树
        while (numRows > 0) {
            ArrayList<Integer> pre = (ArrayList<Integer>) ans.get(len - 2);//获取上一行
            ArrayList<Integer> arrayList = new ArrayList<>();//新建当前行List

            for (int i = 0; i < len; ++i) {//依据上一行，构造当前行，A[i][j]=A[i-1][j-1]+A[i-1][j]
                int l, r;//l,r代表上行的两个数
                if (i - 1 < 0) {//若i为0，A[i][j]=A[i-1][j]
                    l = 0;
                } else {
                    l = pre.get(i - 1);
                }
                if (i == pre.size()) {//若为最后一个，A[i][j]=A[i-1][j]
                    r = 0;
                } else {
                    r = pre.get(i);
                }
                arrayList.add(l + r);//相加，添加到行List中

            }
            ans.add(arrayList);//将当前行加入List
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
