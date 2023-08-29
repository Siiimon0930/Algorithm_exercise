package codeCapriccio.binaryTree;

import java.util.ArrayList;
import java.util.List;

/*
* leetcode257. 二叉树的所有路径:
*   给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
* 解题思路：
*/
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if(root == null)
            return result;
        List<Integer> path = new ArrayList<Integer>();
        postOrder(path, root, result);
        return result;
    }

    public void postOrder(List<Integer> path, TreeNode root, List<String> result){
        path.add(root.val);
        if(root.left == null && root.right == null){
            result.add(listToString(path));
        }
        if(root.left != null){
            // 回溯
            postOrder(path, root.left, result);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            // 回溯
            postOrder(path, root.right, result);
            path.remove(path.size()-1);
        }
    }

    public String listToString(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            if(i != list.size() - 1)
                stringBuilder.append("->");
        }
        return stringBuilder.toString();
    }
}
