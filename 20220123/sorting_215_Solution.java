// thoughts: 1. I can use priorityqueue, time complexity is O(N2)
// 2. quickSelect
import java.util.Random;

class Solution {
    int[] nums;
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        // kth largest element is (n - k + 1)th smallest element in array, its idx is n - k
        return quickSelect(0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int left, int right, int k) {
        if (left == right) return nums[left];
        int pivotIdx = new Random().nextInt(right - left) + left;
        pivotIdx = partition(left, right, pivotIdx);
        if (pivotIdx == k) return nums[pivotIdx];
        else if (pivotIdx < k) return quickSelect(pivotIdx + 1, right, k);
        else return quickSelect(left, pivotIdx - 1, k);
    }
    
    private int partition(int left, int right, int pivotIdx) {
        int pivot = nums[pivotIdx];
        int storeIdx = left;
        swap(pivotIdx, right);
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(storeIdx++, i);
            }
        }
        swap(storeIdx, right);
        return storeIdx;
    }
    
    private void swap(int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}