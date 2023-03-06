package codeCapriccio.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    /*
    * 题意（leetcode40. 组合总和 II）：
    *   给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
    *   candidates中的每个数字（元素）在每个组合中只能使用一次。
    *   注意：解集不能包含重复的组合，candidates中不同元素的数值可能相同，所以可能出现同样组合，需要去重
    * 解题思路：
    *   难点：去重思路：1.used数组，树层去重，树枝不需要去重 2.startIndex实现树层去重
    */

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private int sum = 0;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(target <= 0 || candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        findCombination(candidates, target, 0, used);
        return res;
    }

    private void findCombination(int[] candidates, int target, int startIndex, boolean[] used){
        if(sum >= target){
            if (sum == target)
                res.add(new ArrayList<>(path));
            return;
        }
        // sum + candidates[i] <= target是剪枝
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 单纯i>0 && candidates[i] == candidates[i-1]无法做到仅树层去重，会把树枝也去重
            //  startIndex去重：if(candidates[i] == candidates[i-1] && i > startIndex)
            if(i>0 && candidates[i] == candidates[i-1] && used[i-1] == false)
                continue;
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            findCombination(candidates, target, i+1, used);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
