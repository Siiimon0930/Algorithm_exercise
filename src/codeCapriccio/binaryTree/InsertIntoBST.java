package codeCapriccio.binaryTree;

public class InsertIntoBST {
    /*
    * 题意（leetcode701. 二叉搜索树中的插入操作）：
    *   给定二叉搜索树（BST）的根节点root和要插入树中的值value，将值插入二叉搜索树。
    *   返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
    *   注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
    * 解题思路：
    *   1. 搜索法（迭代）：一直在二叉搜索树中找value，如果找到直接return root不插入，如果找至空节点，则说明未找到，将其插入该空节点位置
    */

    // 1.迭代法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果是一颗空树，则创建根节点返回
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.val == val)      // 发现和val相等的节点直接return，不插入
                return root;
            else if(cur.val < val){
                pre = cur;
                cur = cur.right;
            }else{
                pre = cur;
                cur = cur.left;
            }
        }
        if(pre.val > val){
            pre.left = new TreeNode(val);
        }else
            pre.right = new TreeNode(val);

        return root;
    }

    // 2. 递归法
    public TreeNode insertIntoBST2(TreeNode root, int val){
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        if(root.val == val)
            return root;
        else if (root.val < val) {
            root.right = insertIntoBST2(root.right, val);   // 这里直接用root.right接住比较妙
        }else
            root.left = insertIntoBST2(root.left, val);
        return root;
    }

}
