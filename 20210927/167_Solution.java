// 2, 7, 11, 15    target = 9
// 7, 2, -2, -6
// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//         for (int i = 0; i < numbers.length; i++) {
//             if (map.containsKey(numbers[i])) return new int[] {map.get(numbers[i]), i + 1};
//             map.put(target - numbers[i], i + 1);
//         }
//         return new int[] {-1, -1};
//     }
// }	

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) return new int[] {start + 1, end + 1};
            else if (sum < target) start++;
            else end--;
        }
        return new int[] {start + 1, end + 1}; 
    }
}