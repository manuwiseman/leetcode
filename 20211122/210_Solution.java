class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] courses = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            courses[i] = new ArrayList<Integer>();
        }

        // populate the relationships between courses
        for (int[] pre : prerequisites) {
            courses[pre[0]].add(pre[1]);
        }

        Stack<Integer> stack = new Stack<Integer>();
        boolean[] globalVisited = new boolean[numCourses];
        boolean[] localVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(globalVisited, localVisited, courses, i, stack)) return new int[0];
        }

        int[] res = new int[numCourses];
        int index = 0;
        for (int i = numCourses - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }

    private boolean hasCycle(boolean[] globalVisited, boolean[] localVisited, List<Integer>[] courses, int node, Stack<Integer> stack) {
        // if localVisited was visited before, cycle detected
        if (localVisited[node]) return true;
        
        // if globalVisited was visited before, means no cycle detected
        if (globalVisited[node]) return false;

        globalVisited[node] = true;
        localVisited[node] = true;

        for (int nextCourse : courses[node]) {
            if (hasCycle(globalVisited, localVisited, courses, nextCourse, stack)) return true;
        }
        localVisited[node] = false;
        stack.push(node);
        return false;
    }
}