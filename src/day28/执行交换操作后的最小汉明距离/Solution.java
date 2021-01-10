package day28.执行交换操作后的最小汉明距离;


import util.UnionFind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 输入：source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
 * 输出：1
 * 解释：source 可以按下述方式转换：
 * - 交换下标 0 和 1 指向的元素：source = [2,1,3,4]
 * - 交换下标 2 和 3 指向的元素：source = [2,1,4,3]
 * source 和 target 间的汉明距离是 1 ，二者有 1 处元素不同，在下标 3 。
 */
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        int n = source.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(source[i])) {
                map.get(source[i]).add(i);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(source[i], set);
            }
        }

        for (int[] allowedSwap : allowedSwaps) {
            uf.union(allowedSwap[0], allowedSwap[1]);
        }

        // map { < 1, {0} >, < 2, {1} > , < 3, {2}>, <4,{3}>   }
        // uf { 1->2 , 3 -> 4}
        // target { 2, 1, 4, 5 }

        int res = n;

        for (int i = 0; i < n; i++) {
            int tar = target[i];

            if (map.containsKey(tar)) {
                Set<Integer> set = map.get(tar);
                for (int s : set) {
                    if (uf.isConnected(s, i)) {
                        set.remove(s);
                        res--;
                        break;
                    }
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumHammingDistance(
                new int[]{1, 2, 3, 4},
                new int[]{2, 1, 4, 5},
                new int[][]{{0, 1}, {2, 3}}
        ));
    }

}