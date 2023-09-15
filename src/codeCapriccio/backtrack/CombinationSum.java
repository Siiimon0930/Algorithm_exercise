package codeCapriccio.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    /*
    * 题意（leetcode39. 组合总和）：
    *   给你一个无重复元素的整数数组candidates和一个目标整数target，找出candidates中可以使数字和为目标数target的所有不同组合 ，
    *   并以列表形式返回。你可以按 任意顺序 返回这些组合。
    *   candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
    * 解题思路：
    *   难点：关键在于怎么去重，[2,2,3]和[3,2,2]怎么去重
    */

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 按题意candidates元素大于等于2，所以target小于1直接return
        if(target <= 1)
            return res;
        findCombination(candidates, target, 0);
        return res;
    }

    public void findCombination(int[] candidates, int target, int startIndex){  // 还是需要startIndex来控制，否则会重复
        if(target <= 0){
            if(target == 0)
                res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            target -= candidates[i];
            path.add(candidates[i]);
            findCombination(candidates, target, i); // 不用i+1了，因为可以重复取同一个元素
            path.removeLast();
            target += candidates[i];
        }
    }

    // -----------------第二遍-----------------
    private int sum = 0;
    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> combine = new LinkedList<>();

    public void backTrack(int[] candidates, int target, int startIndex){
        if(sum == target){
            result.add(new ArrayList<>(combine));
            return;
        }
        if(sum > target)
            return;
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            combine.add(candidates[i]);
            backTrack(candidates, target, i);
            sum -= candidates[i];
            combine.removeLast();

        }
    }
    public List<List<Integer>> combinationSum_2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return result;
    }
}
