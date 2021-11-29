class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<int[]>();
        // sort the array like [[7, 0], [7, 1], [6, 0]...]
        Arrays.sort(people, new Comparator<int[]>() {
            @Override public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });
        
        for (int[] p : people) {
            list.add(p[1], p);
        }
        
        return list.toArray(new int[0][0]);
    }
}