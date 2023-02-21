package codeCapriccio.binaryTree;

import java.util.Arrays;

public class BuildTree {
    /*
    * 题意（leetcode106. 从中序与后序遍历序列构造二叉树）：
    *   给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
    * 解题思路：后序最后一个元素是根节点，在中序数组中根节点元素左边的是左子树，右边的是右子树，然后再递归
    * */

    // 中序和后序
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int inPosition = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == postorder[postorder.length - 1]){
                inPosition = i;
                break;
            }
        }

        int[] leftInOrder = new int[inPosition];
        int[] rightInorder = new int[inorder.length - inPosition - 1];
        int[] leftPostOrder = new int[leftInOrder.length];
        int[] rightPostOrdet = new int[rightInorder.length];
        System.arraycopy(inorder, 0, leftInOrder, 0, leftInOrder.length);
        System.arraycopy(inorder, inPosition+1, rightInorder, 0, rightInorder.length);
        System.arraycopy(postorder, 0, leftPostOrder, 0, leftPostOrder.length);
        System.arraycopy(postorder, leftPostOrder.length, rightPostOrdet, 0, rightPostOrdet.length);

        root.left = buildTree(leftInOrder, leftPostOrder);
        root.right = buildTree(rightInorder, rightPostOrdet);

        return root;
    }

    // 前序和中序
    public TreeNode buildTree2(int[] inorder, int[] preorder) {
        if(preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);

        int inPosition = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[preorder.length - 1]){
                inPosition = i;
                break;
            }
        }

        int[] leftInOrder = new int[inPosition];
        int[] rightInorder = new int[inorder.length - inPosition - 1];
        int[] leftPreOrder = new int[leftInOrder.length];
        int[] rightPreOrdet = new int[rightInorder.length];
        System.arraycopy(inorder, 0, leftInOrder, 0, leftInOrder.length);
        System.arraycopy(inorder, inPosition+1, rightInorder, 0, rightInorder.length);
        System.arraycopy(preorder, 1, leftPreOrder, 0, leftPreOrder.length);
        System.arraycopy(preorder, 1 + leftPreOrder.length, rightPreOrdet, 0, rightPreOrdet.length);

        root.left = buildTree(leftInOrder, leftPreOrder);
        root.right = buildTree(rightInorder, rightPreOrdet);

        return root;
    }
}
