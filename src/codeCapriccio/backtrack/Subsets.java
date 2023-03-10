package codeCapriccio.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    /*
    * 题意（leetcode78. 子集）：
    *   给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    *   解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    * 解题思路：
    *   与组合、分割问题相同点是终止条件，最大不同点是回收结果是在所有节点上，而组合分割问题只在叶子节点上
    */

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        getSubsets(nums, 0);
//        res.add(new ArrayList<>());  手动添加一个空集
        return res;
    }

    private void getSubsets(int[] nums, int startIndex){
        res.add(new ArrayList<>(path));         // 放这里也是每一次递归的收获处理
        if(startIndex >= nums.length)
            return;
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
//            res.add(new ArrayList<>(path));   // 如果把收集的处理放在这里，需要最后手动添加一个空集
            getSubsets(nums, i+1);
            path.removeLast();
        }
    }
}
