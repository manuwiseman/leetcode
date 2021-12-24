class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // 1. construct the map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        // 2. sort the map based on values, ascending order
        List<Integer> values = new ArrayList<Integer>(map.values());
        Collections.sort(values);
        // 3. track # of elements we remove and extract from final result
        int idx = 0;
        while (k > 0) {
            k -= values.get(idx);
            if (k >= 0) idx++;
        }
        
        return values.size() - idx;
    }
}