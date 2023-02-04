package codeCapriccio.binaryTree;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.*;

public interface IterativeTraversal {
    //TODO: 迭代遍历：前中后

    // 1. 前序迭代遍历
    default List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
        return res;
    }


    // 2. 中序迭代遍历：与前序和后序写法不同
    default List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    // 3. 后序迭代遍历
    default List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.left != null)
                stack.push(temp.left);
            if(temp.right != null)
                stack.push(temp.right);
        }
        Collections.reverse(res);
        return res;
    }

    // 4. 统一风格代码见代码随想录
}
