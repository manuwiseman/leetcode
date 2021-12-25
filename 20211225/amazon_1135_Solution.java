class Solution {
    public int minimumCost(int n, int[][] connections) {
        // if# of connections is less than n - 1, not possible to connect all cities
        if (connections.length < n - 1) return -1;
        // sort the connections based on cost
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        DSU dsu = new DSU(n);
        int count = 0, ans = 0;
        for (int[] conn : connections) {
            int a = conn[0];
            int b = conn[1];
            // if a and b are already connected then continue
            if (dsu.isSameGroup(a, b)) continue;
            dsu.union(a, b);
            count++;
            ans += conn[2];
        }
        
        return count == n - 1 ? ans : -1;
    }
}

class DSU {
    int[] parents;
    int[] weights;
    
    public DSU(int n) {
        parents = new int[n + 1];
        weights = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
            weights[i] = 1;
        }
    }
    
    // find the root (parent[root] == root)
    public int find(int x) {
        while (parents[x] != x) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return parents[x];
    }
    
    public boolean isSameGroup(int x, int y) {
        return find(x) == find(y);
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;
        if (weights[rootX] >= weights[rootY]) {
            parents[rootY] = rootX;
            weights[rootX] += weights[rootY];
        } else {
            parents[rootX] = rootY;
            weights[rootY] += weights[rootX];
        }
    }
}