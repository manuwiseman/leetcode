class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] courses = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
        	courses[i] = new ArrayList<Integer>();
        }

        // populate the relationships between courses
        for (int[] pre : prerequisites) {
        	courses[pre[0]].add(pre[1]);
        }

        boolean[] globalVisited = new boolean[numCourses];
        boolean[] localVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
        	if (hasCycle(globalVisited, localVisited, courses, i)) return false;
        }

        return true;
    }

    private boolean hasCycle(boolean[] globalVisited, boolean[] localVisited, List<Integer>[] courses, int node) {
    	// if localVisited was visited before, cycle detected
    	if (localVisited[node]) return true;
        
        // if globalVisited was visited before, means no cycle detected
    	if (globalVisited[node]) return false;

    	globalVisited[node] = true;
    	localVisited[node] = true;

    	for (int nextCourse : courses[node]) {
    		if (hasCycle(globalVisited, localVisited, courses, nextCourse)) return true;
    	}
    	localVisited[node] = false;
    	return false;
    }
}