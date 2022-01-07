class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<Integer>();
        int maxHeight = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                list.add(i);
                maxHeight = Integer.max(maxHeight, heights[i]);
            }
        }
        
        int[] results = new int[list.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = list.get(results.length - 1 - i);
        }
        return results;
    }
}