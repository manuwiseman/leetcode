class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        List<Integer> values = new ArrayList<Integer>(map.values());
        Collections.sort(values);
        
        int index = 0;
        while (index < values.size() && k > 0) {
            int value = values.get(index);
            if (value > k) {
                break;
            } else {
                k -= value;
                index++;
            }
        }
        
        return values.size() - index;
    }
}