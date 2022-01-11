class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[n];
        String[] array = logs.get(0).split(":");
        stack.push(Integer.parseInt(array[0]));
        int i = 1, prev = Integer.parseInt(array[2]);
        
        while (i < logs.size()) {
            String[] s = logs.get(i).split(":");
            if(s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += Integer.parseInt(s[2]) - prev;
                }
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
                
            } else {
                result[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return result;
    }
}