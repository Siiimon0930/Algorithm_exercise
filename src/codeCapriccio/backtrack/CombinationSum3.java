package codeCapriccio.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
    /*
    * 题意（leetcode216. 组合总和 III）：
    *   找出所有相加之和为n 的k个数的组合，且满足下列条件：只使用数字1到9、每个数字最多使用一次
    *   返回所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
    * 解题思路：
    *   和组合问题一样，只不过多了个sum限定条件
    */

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> combine = new LinkedList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        if(k > 9)
            return res;
        findCombine(k, n, 1);
        return res;
    }

    public void findCombine(int k, int n, int startIndex){
        if(combine.size() == k){    // 这里递归终止条件不能是combine.size() == k && sum == n，否则回无限递归，栈溢出。
            if(sum == n)
                res.add(new ArrayList<>(combine));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - combine.size()) + 1 ; i++) { // 剪枝
            sum += i;
            combine.add(i);
            findCombine(k, n, i+1);
            sum -= i;
            combine.removeLast();
        }

    }

    // ----------------------第二遍-------------------------
    int getCombineSum(List<Integer> combine){
        int sum = 0;
        for (Integer integer : combine) {
            sum += integer.intValue();
        }
        return sum;
    }
    public void backTrack(int k, int n, int startIndex){
        if(combine.size() == k){
            if(getCombineSum(combine) == n)
                res.add(new LinkedList<>(combine));
            return;
        }

        for (int i = startIndex; i <= 9 - (k - combine.size()) + 1; i++) {
            combine.add(i);
            backTrack(k, n, i+1);
            combine.removeLast();
        }
    }
    public List<List<Integer>> combinationSum3_2(int k, int n) {
        backTrack(k, n, 1);
        return res;
    }

}
