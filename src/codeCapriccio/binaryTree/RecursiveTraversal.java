package codeCapriccio.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class RecursiveTraversal {
    // 递归遍历：前中后序，吐槽点：他题解函数参数这么设计必须要两个函数才可实现
    // 1. 前序
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    public void preorder(List<Integer> res ,TreeNode r){
        if(r != null){
            res.add(r.val);
            preorder(res, r.left);
            preorder(res, r.right);
        }else {
            return;
        }
    }

    // 2. 中序
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res, root);
        return res;
    }

    public void inorder(List<Integer> res ,TreeNode r){
        if(r != null){
            inorder(res, r.left);
            res.add(r.val);
            inorder(res, r.right);
        }else {
            return;
        }
    }

    // 3. 后序
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(res, root);
        return res;
    }

    public void postorder(List<Integer> res ,TreeNode r){
        if(r != null){
            postorder(res, r.left);
            postorder(res, r.right);
            res.add(r.val);
        }else {
            return;
        }
    }
}
