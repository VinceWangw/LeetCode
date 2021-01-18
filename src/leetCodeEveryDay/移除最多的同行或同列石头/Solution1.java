package leetCodeEveryDay.移除最多的同行或同列石头;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {


    /**
     *  [0, 0], [0, 1], [1, 0]
     */
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();

        for (int[] stone : stones) {
            // 下面这三种写法任选其一
            // unionFind.union(~stone[0], stone[1]);
            // unionFind.union(stone[0] - 10001, stone[1]);
            unionFind.union(stone[0] + 10001, stone[1]);
            System.out.println("union:( " + (stone[0] + 10001) + " , " + stone[1] + " )");
        }
        return stones.length - unionFind.getCount();
    }

    private class UnionFind {

        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                // 并查集集中新加入一个结点，结点的父亲结点是它自己，所以连通分量的总数 +1
                count++;
            }

            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent.put(rootX, rootY);
            // 两个连通分量合并成为一个，连通分量的总数 -1
            count--;
        }


    }

    public static void main(String[] args) {
        System.out.println(new Solution1().removeStones(new int[][]{{0, 1}, {0, 0}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println(new Solution1().removeStones(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(new Solution1().removeStones(new int[][]{{0, 1}, {1, 0}, {1, 1}}));

    }
}

