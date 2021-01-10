package util;

/**
 * @author wangfeng
 */
public class UnionFind {

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