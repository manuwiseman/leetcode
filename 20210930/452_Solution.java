// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         Stack<int[]> stack = new Stack<int[]>();
//         Arrays.sort(points, (a, b) -> a[1] - b[1]);
        
//         for (int i = 0; i < points.length; i++) {
//             while (!stack.isEmpty()) {
//                 int[] last_overlap = stack.peek();
//                 if (last_overlap[1] < points[i][0]) {
//                     stack.push(points[i]);
//                 } else if (points[i][0] <= last_overlap[0]) {
//                     continue;
//                 } else {
//                     stack.pop();
//                     stack.push(new int[]{points[i][0], last_overlap[1]});
//                 }
                    
//             }
//             stack.push(points[i]);
//         }
//         return stack.size();
//     }
// }

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int count = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            count++;
            end = points[i][1];
        }
        
        return count;
    }
}