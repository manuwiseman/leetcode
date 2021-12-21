class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<List<String>>();
        int start = 0, bsStart = 0;
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            start = findLowestIndex(prefix, bsStart, products);
            List<String> list = new ArrayList<String>();
            for (int i = start; i < Math.min(start + 3, products.length); i++) {
                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix)) break;
                list.add(products[i]);
            }
            ans.add(list);
            bsStart = start;
        }
        return ans;
    }
    
    private int findLowestIndex(String prefix, int bsStart, String[] products) {
        int i = bsStart, j = products.length, mid;
        while (i < j) {
            mid = i + (j - i) / 2;
            if (products[mid].compareTo(prefix) >= 0) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}