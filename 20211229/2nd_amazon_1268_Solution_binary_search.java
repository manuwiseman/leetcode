class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<List<String>>();
        // 1. sort the array
        Arrays.sort(products);
        
        String prefix = "";
        int start = 0, bsStart = 0;
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            // 2. binary search for each prefix and get the lowest index
            start = findLowestIndex(prefix, products, bsStart);
            List<String> list = new ArrayList<String>();
            // 3. get at most 3 suggestions and add to result
            for (int i = start; i < Math.min(start + 3, products.length); i++) {
                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix)) break;
                list.add(products[i]);
            }
            ans.add(list);
            bsStart = start;
        }
        return ans;  
    }
     
    // return the starting index for us to search suggestions, given prefix
    private int findLowestIndex(String prefix, String[] products, int bsStart) {
        int l = bsStart, r = products.length, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (products[mid].compareTo(prefix) >= 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}