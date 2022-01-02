class Solution {
    public int minimumCost(int n, int[][] connections) {
        int cost = 0, count = 0;
        DSU dsu = new DSU(n);
        // 1. sort the connections based on their cost, ascendingly
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        for (int[] conn : connections) {
            if (!dsu.isConnected(conn[0], conn[1])) {
                dsu.union(conn[0], conn[1]);
                cost += conn[2];
                count++;
            }
        }
        
        return count == n - 1 ? cost : -1;
    }
}

class DSU {
    int[] parents;
    int[] weights;
    
    // size is number of cities
    public DSU(int size) {
        parents = new int[size + 1];
        weights = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            parents[i] = i;
            weights[i] = 1;
        }
    }
    
    // union 2 nodes that no originally connected, the root node is the node with more weight
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
    
    // return root parent node of x
    public int find(int x) {
        while (parents[x] != x) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }
    
    // check if x and y are already connected or not
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}