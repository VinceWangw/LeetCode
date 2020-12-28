package day14.最大矩形;


import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int max = 0;
        int[] heights = new int[matrix[0].length];
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (chars[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea2(heights));
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {

        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        Deque<Integer> stack = new LinkedList<>();
        int max = 0;

        for (int i = 0; i < tmp.length; i++) {
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int top = stack.pop();
                max = Math.max(max, tmp[top] * (i - stack.peek() - 1));
            }
            stack.push(i);

        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(new Solution().maximalRectangle(matrix));

    }
}