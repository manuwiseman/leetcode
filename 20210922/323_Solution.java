class Solution {
    public int countComponents(int n, int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(n);
        int count = 0;
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            
            if (disjointSet.isInSameGroup(a, b)) continue;
            disjointSet.Union(a, b);
            count++;
        }
        return n - count;
    }
}

class DisjointSet {
	private int[] weights;
	private int[] parents;

	public DisjointSet(int n) {
		this.weights = new int[n + 1];
		this.parents = new int[n + 1];

		for (int i = 0; i < n; i++) {
			this.weights[i] = 1;
			this.parents[i] = i;
		}
	}

	// check if a, b are in the same group (have the same root) or not 
	public boolean isInSameGroup(int a, int b) {
		return find(a) == find(b);
	}

	// find the root
	public int find(int a) {
		while (a != this.parents[a]) {
			this.parents[a] = this.parents[parents[a]];
			a = this.parents[a];
		}
		return a;
	}

	public void Union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) return;

		if (this.weights[rootA] > this.weights[rootB]) {
			parents[rootB] = rootA;
			this.weights[rootA] += this.weights[rootB];
		} else {
			parents[rootA] = rootB;
			this.weights[rootB] += this.weights[rootA];
		}
	}
}