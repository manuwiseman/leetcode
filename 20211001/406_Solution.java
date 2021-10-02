class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a, int[] b) {
        		return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        	}
        });

        List<int[]> list = new ArrayList<int[]>();
        for (int[] p : people) {
        	list.add(p[1], p);
        }

        return list.toArray(new int[people.length][2]);
    }
}