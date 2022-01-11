class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, Integer> emailToId = new HashMap<String, Integer>();
        Map<String, String> emailToName = new HashMap<String, String>();
        int idx = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                if (!emailToId.containsKey(email)) emailToId.put(email, idx++);
                emailToName.put(email, name);
                dsu.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }
        
        Map<Integer, List<String>> ans = new HashMap<Integer, List<String>>();
        for (String email : emailToName.keySet()) {
            int i = dsu.find(emailToId.get(email));
            ans.putIfAbsent(i, new ArrayList<String>());
            ans.get(i).add(email);
        }
        
        for (List<String> emails : ans.values()) {
            Collections.sort(emails);
            emails.add(0, emailToName.get(emails.get(0)));
        }
        
        return new ArrayList<List<String>>(ans.values());
    }
}

class DSU {
    int[] parent;
    
    public DSU() {
        this.parent = new int[10000];
        for (int i = 0; i < 10000; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) x = find(parent[x]);
        return x;
    }
    
    public void union(int x, int y) {
        parent[find(y)] = find(x);
    }
}