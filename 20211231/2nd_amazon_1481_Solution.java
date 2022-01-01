// thoughts: we should always remove the element with less count
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // 1. put element and their count into a map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
            
        // 2. sort the map based on value
        List<Integer> values = new ArrayList<Integer>(map.values());
        Collections.sort(values);
        
        // 3. remove count of elements starting from the least
        int idx = 0;
        while (k > 0) {
            k -= values.get(idx);
            if (k >= 0) idx++;
        }
        
        return values.size() - idx;
    }
}