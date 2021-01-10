package days.day10.二叉搜索树中第K小的元素;

import util.TreeNode;

class Solution {
    public int kthSmallest(TreeNode root, int k) {

        if (count(root.left) + 1 == k){
            return root.val;
        }else if (count(root.left)  >= k){
            return kthSmallest(root.left, k);
        }else {
            return kthSmallest(root.right,k - count(root.left ) -1);
        }
    }

    private int count(TreeNode root){
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
}