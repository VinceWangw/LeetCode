package days.day10.二叉树的锯齿形层次遍历;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        while (!queue.isEmpty() || root != null){
            int count = 0;
            queue.add(root);
            count ++;

            TreeNode node = queue.poll();

        }
        //TODO return
        return null;
    }
}