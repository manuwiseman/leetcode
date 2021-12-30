class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int count = 0;
        // sort boxTypes array
        Arrays.sort(boxTypes, (a, b) -> (a[1] - b[1]));
        
        for (int i = boxTypes.length - 1; i >= 0 && truckSize >= 0; i--) {
            count += Math.min(boxTypes[i][0], truckSize) * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
        }
        
        return count;
    }
} 