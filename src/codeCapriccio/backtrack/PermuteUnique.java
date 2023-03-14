package codeCapriccio.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {
    /*
    * 题意（leetcode47. 全排列 II）：
    *   给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    * 解题思路：
    *   和全排列Ⅰ类似，多一部排序去重操作
    */

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if(i>0 && nums[i] == nums[i-1] && used[i-1] == false)
                continue;
            if(!used[i]){
                used[i] = true;
                path.add(nums[i]);
                findPath(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
