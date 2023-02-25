package codeCapriccio.binaryTree;

import java.util.*;
import java.util.stream.Collectors;

public class FindMode {
    /*
    * 题意（leetcode501. 二叉搜索树中的众数）：
    *   给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
    * 解题思路：
    *   1. 暴力法：遍历树，用map保存遍历结果及出现频率。
    *   2. 双指针法一个pre和cur指针
    */

    // 1.暴力法
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list.stream().mapToInt(Integer::intValue).toArray();
        // 获得频率 Map
        searchBST(root, map);
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toList());
        list.add(mapList.get(0).getKey());
        // 把频率最高的加入 list
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                list.add(mapList.get(i).getKey());
            } else {
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    void searchBST(TreeNode curr, Map<Integer, Integer> map) {
        if (curr == null) return;
        map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
        searchBST(curr.left, map);
        searchBST(curr.right, map);
    }

    // 2.双指针法
    private List<Integer> res = new ArrayList<>();
    int maxFre = 0;
    int curFre = 1;
    TreeNode pre = null;

    public int[] findMode2(TreeNode root) {
        traverser(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    public void traverser(TreeNode root){
        if(root == null)
            return;
        traverser(root.left);
        if(pre == null || pre.val != root.val){
            curFre = 1;
        }else{
            curFre++;
        }
        if(curFre > maxFre){
            maxFre = curFre;
            res.clear();
            res.add(root.val);
        } else if (curFre == maxFre) {
            res.add(root.val);
        }
        pre = root;
        traverser(root.right);
    }
}
