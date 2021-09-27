class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegress = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
        	int dest = prerequisites[i][0];
        	int src = prerequisites[i][1];

        	List<Integer> list = adjList.getOrDefault(src, new ArrayList<Integer>());
        	list.add(dest);
        	adjList.put(src, list);
        	indegress[dest] += 1;
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < numCourses; i++) {
        	if (indegress[i] == 0) queue.add(i);
        }

        int index = 0;
        while (!queue.isEmpty()) {
        	int node = queue.poll();
        	topologicalOrder[index++] = node;

        	if (adjList.containsKey(node)) {
        		for (int i : adjList.get(node)) {
        			indegress[i]--;
        			if (indegress[i] == 0) {
        				queue.add(i);
        			}
        		}
        	}
        }

        if (index == numCourses) return topologicalOrder;
        return new int[0];
    }
}