//nums = [1,1,1,2,2,3], k = 2
// map = [{1, 3}, {2, 2}, {3, 1}]
// unique = [1, 2, 3];
import java.util.Random;

class Solution {
    Map<Integer, Integer> count;
    int[] unique;
    
    public int[] topKFrequent(int[] nums, int k) {
        this.count = new HashMap<Integer, Integer>();
        for (int num : nums) {
            this.count.put(num, this.count.getOrDefault(num, 0) + 1);
        }
        
        int size = count.size();
        this.unique = new int[size];
        int i = 0;
        for (int key : count.keySet()) {
            this.unique[i++] = key;
        }
        quickselect(0, size - 1, size - k);
        return Arrays.copyOfRange(this.unique, size - k, size);
    }
    
    private void quickselect(int left, int right, int k_smallest) {
        if (left == right) return;
        Random random = new Random();
        int pivot_index = left + random.nextInt(right - left);
        pivot_index = partition(left, right, pivot_index);
        
        if (pivot_index == k_smallest);
        else if (pivot_index < k_smallest) quickselect(pivot_index + 1, right, k_smallest);
        else quickselect(left, pivot_index - 1, k_smallest);
    }
    
    private int partition(int left, int right, int pivot_index) {
        int pivot_frequency = count.get(unique[pivot_index]);
        swap(pivot_index, right);
        int store_index = left;
        
        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(store_index++, i);
            }
        }
        swap(store_index, right);
        return store_index;
    }
    
    private void swap(int a, int b) {
        int temp = this.unique[a];
        this.unique[a] = this.unique[b];
        this.unique[b] = temp;
    }
}