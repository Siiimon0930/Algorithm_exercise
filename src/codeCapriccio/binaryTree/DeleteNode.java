package codeCapriccio.binaryTree;

public class DeleteNode {
    /*
    * 题意（leetcode450. 删除二叉搜索树中的节点）：
    *   给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。
    *   返回二叉搜索树（有可能被更新）的根节点的引用。
    * 解题思路：
    *   1.递归法：先找到位置，而后如果左子树不为空，则找到左子树最大的值来顶替key节点，如果左子树为空，则直接返回右子树
    */

    // 1.递归法
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(root.val == key){
            // 1.左右孩子节点为空，直接删除返回null
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null && root.right != null)    // 2.左为空，右不为空直接返回右
                return root.right;
            else if(root.left != null && root.right == null)            // 3.左右为空，左不为空直接返回左
                return root.left;
            else{
                TreeNode rightMin = root.right;
                while(rightMin.left != null)    // 找到右子树最小节点
                    rightMin = rightMin.left;
                rightMin.left = root.left;      // 把左子树挂到右子树最小节点的左节点
                return root.right;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }


}
