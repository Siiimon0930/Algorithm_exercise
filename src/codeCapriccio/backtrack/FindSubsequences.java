package codeCapriccio.backtrack;

import java.util.*;

public class FindSubsequences {
    /*
    * 题意（leetcode491. 递增子序列）：
    *   给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
    *   你可以按 任意顺序 返回答案。
    *   数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
    * 解题思路：
    *   这里和子集Ⅱ的去重思路不同，本题不可对nums排序，所以不可通过nums[i] == nums[i-1]来判断，
    *   如【4，7，6，7】中如使用nums[i] == nums[i-1]来判断则会出现两个【4，7】，
    *   所以需要对属于同一父节点下的选项进行重复判断，而不能排序导致无法通过i和i-1比较来完成，
    *   故需要一个map或set来记录当前层出现过哪些数字，确保同一父节点同一层内相同数字不重复使用。
    */

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        findPath(nums, 0);
        return res;
    }

    private void findPath(int[] nums, int startIndex){
        if(path.size() >= 2)
            res.add(new ArrayList<>(path));
        if(startIndex >= nums.length)   // 这个条件其实可要可不要
            return;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if( (!path.isEmpty() && nums[i] < path.getLast()) || map.getOrDefault(nums[i], 0) != 0)
                continue;
            path.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            findPath(nums, i+1);
            path.removeLast();
        }
    }
}
