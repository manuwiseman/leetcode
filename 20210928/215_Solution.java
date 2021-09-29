import java.util.Random;

public class Solution {
	int[] nums;

	public int findKthLargest(int[] nums, int k) {
		this.nums = nums;
		int size = nums.length;
		// kth largest is (n - k + 1)th smallest, index is n -k 
		return quickselect(0, size - 1, size - k);
    }

    private int quickselect(int left, int right, int k_smallest) {
    	if (left == right) return this.nums[left];
    	Random random = new Random();
    	int pivot_index = left + random.nextInt(right - left);
    	pivot_index = partition(left, right, pivot_index);
    	if (pivot_index == k_smallest) return this.nums[pivot_index];
    	else if (pivot_index < k_smallest) return quickselect(pivot_index + 1, right, k_smallest);
    	return quickselect(left, pivot_index - 1, k_smallest);
    }

    private int partition(int left, int right, int pivot_index) {
    	int pivot = this.nums[pivot_index];
    	swap(pivot_index, right);
    	int store_index = left;

    	for (int i = left; i <= right; i++) {
    		if (this.nums[i] < pivot) {
    			swap(store_index++, i);
    		}
    	}
    	swap(store_index, right);
    	return store_index;
    }

    private void swap(int a, int b) {
    	int temp = this.nums[b];
    	this.nums[b] = this.nums[a];
    	this.nums[a] = temp;
    }
}