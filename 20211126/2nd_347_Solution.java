import java.util.Random;

class Solution {
    int[] unique;
    Map<Integer, Integer> map;
    
    public int[] topKFrequent(int[] nums, int k) {
        // populate the map
        this.map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            this.map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int size = this.map.size(), index = 0;
        this.unique = new int[size];
        // get unique array e.g. [1, 2, 3] from [1, 1, 1, 2, 2, 3]
        for (int key : this.map.keySet()) {
            this.unique[index++] = key;
        }
        
        // sort the unique array
        quickSelect(0, size - 1, k - 1);
        return Arrays.copyOfRange(this.unique, 0, k);
    }
    
    private void quickSelect(int left, int right, int kLargest) {
        if (left == right) return;
        Random random = new Random();
        int pivot_idx = left + random.nextInt(right - left);
        pivot_idx = partition(left, right, pivot_idx);
        if (kLargest == pivot_idx) return;
        else if (kLargest < pivot_idx) quickSelect(left, pivot_idx - 1, kLargest);
        else quickSelect(pivot_idx + 1, right, kLargest);
    }

    private int partition(int left, int right, int pivot_idx) {
        int pivot = this.map.get(this.unique[pivot_idx]);
        swap(pivot_idx, right);
        int store_idx = left;

        for (int i = left; i <= right; i++) {
            if (this.map.get(this.unique[i]) > pivot) {
                swap(store_idx++, i);
            }
        }
        swap(store_idx, right);
        return store_idx;
    }

    private void swap(int a, int b) {
        int temp = this.unique[a];
        this.unique[a] = this.unique[b];
        this.unique[b] = temp;
    }
}