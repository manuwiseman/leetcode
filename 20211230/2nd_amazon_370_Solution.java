//00000
//02220 -> //0200-2 -> 02220
//0230-2 -> 02553
// -223-2

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] array = new int[length];
        for (int[] update : updates) {
            array[update[0]] += update[2];
            if (update[1] + 1 < length) array[update[1] + 1] -= update[2];
        }
        
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += array[i];
            array[i] = sum;
        }
        
        return array;
    }
}