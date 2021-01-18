package classes.并查集.l684冗余连接;


/**
 * 在本问题中, 树指的是一个连通且无环的无向图。
 *
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 *
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 *
 */
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

    public int[] findRedundantConnection(int[][] edges) {


        //输入: [[1,2], [1,3], [2,3]]
        //输出: [2,3]
        //解释: 给定的无向图为:
        //  1
        // / \
        //2 - 3
        UnionFind uf = new UnionFind(edges.length);

        int[] ans = new int[2];
        for (int[] edge : edges){
            if (uf.isConnected(edge[0]-1, edge[1] - 1)){
                ans[0] = edge[0];
                ans[1] = edge[1];
            }
            uf.union(edge[0]-1,edge[1]-1);
        }
        return ans;
    }
}