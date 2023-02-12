package codeCapriccio.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public interface BinaryTreePaths {
    /*
    * 题意（leetcode257. 二叉树的所有路径）：输入：root = [1,2,3,null,5]  输出：["1->2->5","1->3"]
    * 解题思路（没写出来，看代码随想录）：
    *   1. 递归法
    *   2. 迭代法（不理解）
    * */

    // 1. 递归法
    default List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();// 存最终的结果
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();// 作为结果中的路径
        traversal(root, paths, res);
        return res;
    }

    default void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);// 前序遍历，中
        // 遇到叶子结点
        if (root.left == null && root.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();// StringBuilder用来拼接字符串，速度更快
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));// 记录最后一个节点
            res.add(sb.toString());// 收集一个路径
            return;
        }
        // 递归和回溯是同时进行，所以要放在同一个花括号里
        if (root.left != null) { // 左
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
        if (root.right != null) { // 右
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
    }


}
