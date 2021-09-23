class Solution {
    public int minimumCost(int n, int[][] connections) {
        DisjointSet disjointSet = new DisjointSet(n);
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int cost = 0, total = 0;

        for (int i = 0; i < connections.length; i++) {
        	int a = connections[i][0];
        	int b = connections[i][1];

        	if (disjointSet.isInSameGroup(a, b)) continue;

        	disjointSet.Union(a, b);
        	cost += connections[i][2];
        	total++;
        }
        if (total == n - 1) {
            return cost;
        }
        return -1;
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