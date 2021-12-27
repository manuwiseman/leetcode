class Solution {
    public int[][] kClosest(int[][] points, int k) {
        return quickselect(points, k);
    }

    private int[][] quickselect(int[][] points, int k) {
    	int left = 0, right = points.length - 1;
    	int pivotIdx = points.length;
    	while (pivotIdx != k) {
    		pivotIdx = partition(points, left, right);
    		if (pivotIdx < k) {
    			left = pivotIdx;
    		} else {
    			right = pivotIdx - 1;
    		}
    	}
    	return Arrays.copyOf(points, k);
    }

    private int partition(int[][] points, int left, int right) {
    	int[] pivotIdx = getPivotIdx(points, left, right);
    	int pivotDist = getSquareDist(pivotIdx);
    	while (left < right) {
    		if (getSquareDist(points[left]) >= pivotDist) {
	    		int[] temp = points[left];
	    		points[left] = points[right];
	    		points[right--] = temp;
	    	} else {
	    		left++;
	    	}
    	}
    	if (getSquareDist(points[left]) < pivotDist) left++;

    	return left;
    }

    private int[] getPivotIdx(int[][] points, int left, int right) {
    	return points[left + (right - left) / 2];
    }

    private int getSquareDist(int[] pivotIdx) {
    	return pivotIdx[0] * pivotIdx[0] + pivotIdx[1] * pivotIdx[1];
    }
}