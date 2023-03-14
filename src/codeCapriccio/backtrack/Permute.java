package codeCapriccio.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    /*
    * 题意（leetcode46. 全排列）：
    *   给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    * 解题思路：
    *   排列问题只在叶子节点收获结果，并且需要一个used数组来记录是否已经使用过
    */

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        findPath(nums, used);
        return res;
    }

    private void findPath(int[] nums, boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }else{
                used[i] = true;
                path.add(nums[i]);
                findPath(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
