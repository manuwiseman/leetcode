class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // 1. sort username & website based on timestamp, using priorityqueue
        PriorityQueue<String[]> pq = new PriorityQueue<String[]>((a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));
        for (int i = 0; i < timestamp.length; i++) {
            String[] session = new String[3];
            session[0] = username[i];
            session[1] = "" + timestamp[i];
            session[2] = website[i];
            pq.add(session);
        }
        
        // 2. per user, get the list of websites the user visited, using hashmap
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        while (!pq.isEmpty()) {
            String[] tuple = pq.poll();
            map.putIfAbsent(tuple[0], new ArrayList<String>());
            map.get(tuple[0]).add(tuple[2]);
        }
        // 3. for each user, we get all possible patterns from the websites user visited and therefore ge the most visited pattern among all users
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        int max = 0;
        String maxPattern = "";
        for (List<String> sites : map.values()) {
            if (sites.size() < 3) continue;
            Set<String> set = getSequences(sites);
            for (String pattern : set) {
                int count = countMap.getOrDefault(pattern, 0) + 1;
                countMap.put(pattern, count);
                if (count > max) {
                    max = count;
                    maxPattern = pattern;
                }
                if (count == max && pattern.compareTo(maxPattern) < 0) {
                    maxPattern = pattern;
                }
            }
        }
        return Arrays.asList(maxPattern.split(","));
    }
    
    private Set<String> getSequences(List<String> sites) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < sites.size(); i++) {
            for (int j = i + 1; j < sites.size(); j++) {
                for (int k = j + 1; k < sites.size(); k++) {
                    set.add(sites.get(i) + ","  + sites.get(j) + "," + sites.get(k));
                }
            }
        }
        return set;
    }
}