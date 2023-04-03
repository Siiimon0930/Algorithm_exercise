package codeCapriccio.greedy;

public class MinCameraCover {
    /*
    * 题意（leetcode968. 监控二叉树）：
    *   给定一个二叉树，我们在树的节点上安装摄像头。
    *   节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
    *   计算监控树的所有节点所需的最小摄像头数量。
    * 解题思路：见代码随想录，很妙！
    *
    */
    private int result = 0;

    public int minCameraCover(TreeNode root) {
        // 根节点还是无覆盖情况，则根节点安装一个摄像头
        if(traversal(root) == 0)
            result++;
        return result;
    }

    private int traversal(TreeNode root){
        // 0 无覆盖 1 有摄像头 2 有覆盖
        if(root == null)
            return 2;
        int left = traversal(root.left);
        int right = traversal(root.right);
        // 左右都有覆盖，则返回0 等待父节点安装摄像头去覆盖
        if(left == 2 && right == 2)
            return 0;
        // 左右至少有一个无覆盖，则返回1 安装摄像头
        if(left == 0 || right == 0){
            result++;
            return 1;
        }
        // 左右至少有一个是有摄像头，则返回2
        if(left == 1 || right == 1)
            return 2;
        return -1;
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}