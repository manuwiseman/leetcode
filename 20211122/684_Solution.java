class Solution {
    int MAX_EDGE_VAL = 1000;
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGE_VAL + 1);
        
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) return edge;
        }
        return new int[]{-1, -1};
    }
}

class DSU {
    int[] parent;
    int[] rank;
    
    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        rank = new int[n];
    }
    
    public int find (int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        if (xr == yr) return false;
        if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
    
}