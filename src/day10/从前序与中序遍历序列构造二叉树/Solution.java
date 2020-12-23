package day10.从前序与中序遍历序列构造二叉树;

import util.TreeNode;

import java.util.TreeMap;

/**
 *功能描述: 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder =  [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @return TreeNode
 * */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 构造[0,len]
        return buildTreeHelper(preorder,0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd){
        if (preBegin > preEnd || inBegin > inEnd){
            return null;
        }

        int val = preorder[preBegin];
        TreeNode root = new TreeNode(val);

        int index = 0;
        for (int i = inBegin; i <= inEnd; i++) {
            if (inorder[i] == val){
                index = i;
            }
        }
        int count1 = index - inBegin;

        root.left =  buildTreeHelper(preorder, preBegin + 1, preBegin + count1 , inorder, inBegin, index - 1);
        root.right = buildTreeHelper(preorder, preBegin + count1 + 1, preEnd, inorder, index + 1, inEnd);

        return root;
    }
}