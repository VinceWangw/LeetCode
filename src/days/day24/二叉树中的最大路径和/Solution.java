package days.day24.二叉树中的最大路径和;
import util.TreeNode;

class Solution {
    int maxPathSum;
    public int maxPathSum(TreeNode root) {

        maxPathSum = Integer.MIN_VALUE;
        getMaxBranch(root);
        return maxPathSum;
    }

    private int getMaxBranch(TreeNode root) {

        if (root == null){
            return 0;
        }
        int left = getMaxBranch(root.left);
        int right = getMaxBranch(root.right);

        maxPathSum = Math.max(maxPathSum,
                Math.max((Math.max(root.val + left, root.val + right)),
                        Math.max(root.val, root.val + left + right)));

        return Math.max(Math.max(left + root.val, right + root.val), root.val);

    }
}