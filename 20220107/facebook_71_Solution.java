class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        ArrayDeque<String> deq = new ArrayDeque<String>();
        
        for (String d : dirs) {
            if (d.equals(".") || d.equals("")) {
                continue;
            } else if (d.equals("..")) {
                if (!deq.isEmpty()) deq.removeLast();
            } else {
                deq.addLast(d);
            }
        }
        
        if (deq.isEmpty()) return "/";
        
        StringBuilder sb = new StringBuilder();
        while (!deq.isEmpty()) {
            sb.append("/");
            sb.append(deq.poll());
        }
        
        return sb.toString();
    }
}