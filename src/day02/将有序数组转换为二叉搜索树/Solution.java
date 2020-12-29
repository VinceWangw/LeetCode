package day02.将有序数组转换为二叉搜索树;

import util.TreeHelper;
import util.TreeNode;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 16:38
 **/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return _sortedArrayToBST(nums, 0, nums.length - 1);
    }

    //[l .... r]
    private TreeNode _sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) return null;

        int n = (r + l + 1) / 2;
        TreeNode root = new TreeNode(nums[n]);
        root.left = _sortedArrayToBST(nums,l,n - 1);
        root.right = _sortedArrayToBST(nums, n + 1, r);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        TreeNode node = new Solution().sortedArrayToBST(nums);
        TreeHelper.printTree(node);
    }
}