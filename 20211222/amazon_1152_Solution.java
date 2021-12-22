class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // 1. sort the websites per user based on user's timestamp
        List<List<String>> sessions = new ArrayList<List<String>>();
        for (int i = 0; i < username.length; i++) {
            List<String> session = new ArrayList<String>();
            session.add(username[i]);
            session.add("" + timestamp[i]);
            session.add(website[i]);
            sessions.add(session);
        }
        sessions.sort((a, b) -> Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1)));
        
        // 2. for each user, get all combinations of possible patterns
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (List<String> session : sessions) {
            map.putIfAbsent(session.get(0), new ArrayList<String>());
            map.get(session.get(0)).add(session.get(2));
        }
        
        // 3. get the most visited pattern
        int maxCount = 0;
        String longest = "";
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        
        for (String key : map.keySet()) {
            List<String> sites = map.get(key);
            if (sites.size() < 3) continue;
            Set<String> seqs = getSequences(sites);
            for (String seq : seqs) {
                int count = countMap.getOrDefault(seq, 0) + 1;
                countMap.put(seq, count);
                if (count > maxCount) {
                    maxCount = count;
                    longest = seq;
                } else if (count == maxCount && seq.compareTo(longest) < 0) {
                    longest = seq;
                }
            }
        }
        return Arrays.asList(longest.split(","));
    }
    
    // return sequences given sites
    private Set<String> getSequences(List<String> sites) {
        Set<String> set = new HashSet<String>();
        int size = sites.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    set.add(sites.get(i) + "," + sites.get(j) + "," + sites.get(k));
                }
            }
        }
        return set;
    }
}