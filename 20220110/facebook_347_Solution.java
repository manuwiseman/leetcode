import java.util.Random;

class Solution {
    Map<Integer, Integer> map;
    int[] nums;
    int[] uniques;
    Random random = new Random();
    
    public int[] topKFrequent(int[] nums, int k) {
        // 1. hashmap to store unique num and its frequences
        this.map = new HashMap<Integer, Integer>();
        this.nums = nums;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int size = map.size(), idx = 0;
        int[] uniques = new int[size];
        for (int unique : map.keySet()) {
            uniques[idx++] = unique;
        }
        this.uniques = uniques;
        quickSelect(0, size - 1, k);
        
        return Arrays.copyOf(uniques, k);
    }
    
    private void quickSelect(int left, int right, int k) {
        if (left == right) return;
        int pivotIdx = left + random.nextInt(right - left);
        pivotIdx = partition(left, right, pivotIdx);
        if (pivotIdx == k) return;
        else if (pivotIdx < k) quickSelect(pivotIdx + 1, right, k);
        else quickSelect(left, pivotIdx - 1, k);
    }
    
    private int partition(int left, int right, int pivotIdx) {
        int pivot = map.get(uniques[pivotIdx]);
        swap(pivotIdx, right);
        int storeIdx = left;
        for (int i = left; i < right; i++) {
            if (map.get(uniques[i]) > pivot) {
                swap(storeIdx++, i);
            }
        }
        swap(storeIdx, right);
        return storeIdx;
    }
    
    private void swap(int i, int j) {
        int temp = uniques[i];
        uniques[i] = uniques[j];
        uniques[j] = temp;
    }
}