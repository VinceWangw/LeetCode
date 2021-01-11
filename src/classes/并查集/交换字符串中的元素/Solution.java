package classes.并查集.交换字符串中的元素;

import java.util.*;

class Solution {

    class UnionFind {

        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public void union(int a, int b) {
            if (find(a) == find(b)) {
                return;
            }
            int aRoot = find(a), bRoot = find(b);

            if (rank[aRoot] < rank[bRoot]) {
                parent[aRoot] = parent[bRoot];
            } else if (rank[bRoot] < rank[aRoot]) {
                parent[bRoot] = parent[aRoot];
            } else {
                parent[aRoot] = parent[bRoot];
                rank[bRoot] += 1;
            }
        }

        public int find(int a) {
            while (a != parent[a]) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
    }

    /**
     * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
     *
     * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
     *
     * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
     *
     * 输入：s = "dcab", pairs = [[0,3],[1,2]]
     * 输出："bacd"
     * 解释：
     * 交换 s[0] 和 s[3], s = "bcad"
     * 交换 s[1] 和 s[2], s = "bacd"
     * 示例 2：
     *
     * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
     * 输出："abcd"
     * 解释：
     * 交换 s[0] 和 s[3], s = "bcad"
     * 交换 s[0] 和 s[2], s = "acbd"
     * 交换 s[1] 和 s[2], s = "abcd"
     *
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int n = s.length();
        UnionFind uf = new UnionFind(n);

        for (List<Integer> list : pairs){
            int a = list.get(0);
            int b = list.get(1);
            uf.union(a, b);
        }

        Map<Integer, Queue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = uf.find(i);
            if (!map.containsKey(p)){
                Queue<Character> pq = new PriorityQueue<>();
                pq.offer(s.charAt(i));
                map.put(p, pq);
            }else {
                map.get(p).offer(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(i).poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       
    }
}
