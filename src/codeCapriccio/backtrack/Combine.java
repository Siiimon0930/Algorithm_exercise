package codeCapriccio.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    /*
    * 题意（leetcode77. 组合）：
    *   给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。你可以按 任何顺序 返回答案。
    * 解题思路：
    *   1.for遍历（无法解决，因为需要嵌套K层，不是效率的事，而是根本写不出）
    *   2.回溯
    */

    // 1.for遍历
//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        if(n < k || n < 1 || k < 1)
//            return res;
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = i + 1;
//        }
//        for(int i = 0; i < n - k + 1; i++){
//            List<Integer> item = new ArrayList<>();
//            for(int j = i; j < i + k; j++){
//                item.add(array[j]);
//            }
//            res.add(item);
//        }
//        return res;
//    }

    // 2.回溯
    List<List<Integer>> res = new ArrayList<>();
    // linkedList才有removeLast方法
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k){
        combineHelper(n, k ,1);
        return res;
    }

    private void combineHelper(int n, int k, int startIndex){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i <= n - (k-path.size()) + 1; i++){ // 剪枝操作
            path.add(i);
            combineHelper(n, k, i+1);
            path.removeLast();
        }
    }

    //---------------------------第二遍---------------------------
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> numCombine = new LinkedList<>();

    private void backtrack(int n, int k, int startIndex){
        if(numCombine.size() == k){
            result.add(new LinkedList<>(numCombine));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            numCombine.add(i);
            backtrack(n, k, i+1);
            numCombine.removeLast();
        }
    }

    public List<List<Integer>> combine2(int n, int k){
        backtrack(n, k ,1);
        return result;
    }

}
