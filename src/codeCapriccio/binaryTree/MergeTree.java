package codeCapriccio.binaryTree;

public class MergeTree {
    /*
    * 题意（617. 合并二叉树）：想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
    *   你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
    * 解题思路：
    *   1. 递归法：就简单中左右（前序思想）
    *   2. 递归法（中序、后序都可以）
    */

    // 1.前序
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        else if(root1 != null && root2 == null)
            return root1;
        else if(root1 == null && root2 != null)
            return root2;
        else{
            TreeNode newNode = new TreeNode(root1.val + root2.val);
            newNode.left = mergeTrees(root1.left, root2.left);
            newNode.right = mergeTrees(root1.right, root2.right);
            return newNode;
        }
    }

    // 2.中序
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        else if(root1 != null && root2 == null)
            return root1;
        else if(root1 == null && root2 != null)
            return root2;
        else{
            root1.left = mergeTrees(root1.left, root2.left);
            root1.val += root2.val;
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }

    // 2.后序
    public TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        else if(root1 != null && root2 == null)
            return root1;
        else if(root1 == null && root2 != null)
            return root2;
        else{
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            root1.val += root2.val;
            return root1;
        }
    }
}
