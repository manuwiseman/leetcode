class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int idx = 0;
        while (idx < flowerbed.length) {
            if (flowerbed[idx] == 0 && (idx == 0 || flowerbed[idx - 1] == 0) && (idx == flowerbed.length - 1 || flowerbed[idx + 1] == 0)) {
                flowerbed[idx] = 1;
                n--;
            }
            idx++;
            if (n == 0) return true;
        }
        
        return false;
    }
}