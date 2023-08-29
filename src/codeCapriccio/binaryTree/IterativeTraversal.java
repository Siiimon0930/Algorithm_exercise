package codeCapriccio.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// 迭代遍历
public class IterativeTraversal {

    /**
     * decription: 迭代先序遍历
     * @param root
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> preorderIterTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            // 边界条件，判空
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp;
        stack.push(root);
        while(!stack.isEmpty()){
            temp = stack.pop();
            result.add(temp.val);
            // 遍历顺序要求 中左右，所以先push右孩子，pop才能先pop左孩子
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
        return result;
    }

    /**
     * decription: 中序迭代遍历
     * @param root
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> inorderIterTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            // 边界条件，判空
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !stack.isEmpty()){
            if (temp != null){
                // 当指针当前节点不为空时，将该节点入栈，并将指针指向当前节点的左孩子
                stack.push(temp);
                temp = temp.left;
            }else {
                // 当指针指向空时，pop出栈顶元素进行遍历，而后将指针指向右孩子
                temp = stack.pop();
                result.add(temp.val);
                temp = temp.right;
            }
        }
        return result;
    }


    /**
     * decription: 后续迭代遍历
     * @param root
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> postorderIterTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            // 边界条件，判空
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp;
        stack.push(root);
        while(!stack.isEmpty()){
            temp = stack.pop();
            result.add(temp.val);
            // 遍历顺序要求 左右中 = 中右左 + reverse
            if(temp.left != null)
                stack.push(temp.left);
            if(temp.right != null)
                stack.push(temp.right);
        }
        // 翻转结果
        Collections.reverse(result);
        return result;
    }

}
