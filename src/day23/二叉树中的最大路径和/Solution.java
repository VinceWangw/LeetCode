package day23.二叉树中的最大路径和;

import util.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 输入：[1,2,3]
 *
 * 1 / \ 2 3
 *
 * 输出：6
 *
 * 输入：[-10,9,20,null,null,15,7]
 *
 * -10 / \ 9 20 / \ 15 7
 *
 * 输出：42
 *
 */

class Solution {
    public int maxPathSum(TreeNode root) {

        return getMax(root);
    }

    private int getMax(TreeNode root) {
        if (root.right == null && root.left == null) {
            return root.val;
        } else if (root.right != null && root.left == null) {
            return Math.max(root.val + getMax(root.right), root.val);
        } else if (root.left != null && root.right == null) {
            return Math.max(root.val + getMax(root.left), root.val);
        }

        int l = getMax(root.left);
        int r = getMax(root.right);
        int m = l + r + root.val;
        int n = root.val;
        return Math.max(Math.max(l,r), Math.max(m,n));
    }
}