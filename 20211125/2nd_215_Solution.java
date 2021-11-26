import java.util.Random;

class Solution {
    int[] nums;
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        // kth largest is (n - k + 1)th smallest, index is n -k 
        return quickSelect(0, size - 1, size - k);
    }

    private int quickSelect(int start, int end, int kSmallest) {
    	if (start == end) return this.nums[start];
    	Random random = new Random();
    	int pivot_idx = start + random.nextInt(end - start);
    	pivot_idx = partition(start, end, pivot_idx);
    	if (pivot_idx == kSmallest) return this.nums[pivot_idx];
    	else if (pivot_idx < kSmallest) return quickSelect(pivot_idx + 1, end, kSmallest);
    	else return quickSelect(start, pivot_idx - 1, kSmallest);
    }

    private int partition(int start, int end, int pivot_idx) {
    	int pivot = this.nums[pivot_idx];
    	swap(pivot_idx, end);
    	int store_idx = start;

    	for (int i = start; i <= end; i++) {
    		if (this.nums[i] < pivot) {
    			swap(store_idx++, i);
    		}
    	}
    	swap(store_idx, end);
    	return store_idx;
    }

    private void swap(int a, int b) {
    	int temp = this.nums[a];
    	this.nums[a] = this.nums[b];
    	this.nums[b] = temp;
    }
}