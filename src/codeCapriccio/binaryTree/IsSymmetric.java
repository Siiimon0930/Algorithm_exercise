package codeCapriccio.binaryTree;

import java.util.ArrayList;
import java.util.List;

public interface IsSymmetric {
    /*
    * 题意（leetcode101对称二叉树）：给你一个二叉树的根节点 root ， 检查它是否轴对称。
    * 解题思路：
    *   1. 如果是轴对称，则左中右遍历 和 右中左遍历应该是一样的。TODO：错误，不能简单通过遍历结果来判断，遍历结果可能会因为不同位置值相同的情况导致产生一样的遍历结果
    *   2. 代码随想录 后序解法
    * */
    // 1. 错误思路
//    default boolean isSymmetric(TreeNode root) {
//        if(root == null)
//            return false;
//        List<Integer> left = new ArrayList<>();
//        List<Integer> right = new ArrayList<>();
//        LMR(root, left);
//        RML(root, right);
//        for(int i = 0; i < left.size(); i++){
//            if(left.get(i) != right.get(i))
//                return false;
//        }
//        return true;
//    }
//
//    default void LMR(TreeNode root, List<Integer> list){
//        if(root == null)
//            return;
//        else{
//            LMR(root.left, list);
//            list.add(root.val);
//            LMR(root.right, list);
//        }
//    }
//
//    default void RML(TreeNode root, List<Integer> list){
//        if(root == null)
//            return;
//        else{
//            RML(root.right, list);
//            list.add(root.val);
//            RML(root.left, list);
//        }
//    }
    default boolean isSymmetric(TreeNode root){
        return compare(root.left, root.right);
    }

    default boolean compare(TreeNode left, TreeNode right){

        if(left != null && right == null)
            return false;
        else if (left == null && right != null)
            return false;
        else if(left == null && right == null)
            return true;
        else if(left.val != right.val)
            return false;

        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);

        return outside && inside;
    }
}
