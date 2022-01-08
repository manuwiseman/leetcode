import java.util.Random;

class Solution {
    int[] nums;
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        // kth largest element is (nums.length + 1 - k)th element, index is nums.length - k
        return quickselect(0, nums.length - 1, nums.length - k);
    }
    
    private int quickselect(int left, int right, int kSmallest) {
        if (left == right) return nums[left];
        Random random  = new Random();
        int pivotIdx = left + random.nextInt(right - left);
        pivotIdx = partition(left, right, pivotIdx);
        if (kSmallest == pivotIdx) return nums[kSmallest];
        else if (kSmallest < pivotIdx) return quickselect(left, pivotIdx - 1, kSmallest);
        else return quickselect(pivotIdx + 1, right, kSmallest);
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
    
    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}