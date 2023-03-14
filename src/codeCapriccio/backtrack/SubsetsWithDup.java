package codeCapriccio.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {
    /*
    * 题意（leetcode90. 子集 II）：
    *   给你一个整数数组 nums ，其中“可能包含重复元素”，请你返回该数组所有可能的子集（幂集）。
    *   解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
    * 解题思路：
    *   和子集Ⅰ问题类似，只不过nums含有重复元素而已
    */

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);      // 必须要先sort才可去重！
        findPath(nums, 0);
        return res;
    }

    private void findPath(int[] nums, int startIndex){
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if(i > startIndex && nums[i] == nums[i-1])
                continue;
            else{
                path.add(nums[i]);
                findPath(nums, i+1);
                path.removeLast();
            }
        }
    }
}
