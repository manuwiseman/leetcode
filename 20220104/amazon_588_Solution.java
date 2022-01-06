// thoughts: 1. use a trie to store the pathes
class FileSystem {
    Trie trie;

    public FileSystem() {
        trie = new Trie();
    }
    
    public List<String> ls(String path) {
        return trie.ls(path);
    }
    
    public void mkdir(String path) {
        trie.insert(path, null);
    }
    
    public void addContentToFile(String filePath, String content) {
        trie.insert(filePath, content);
    }
    
    public String readContentFromFile(String filePath) {
        return trie.getContent(filePath);
    }
}

class Trie {
    TrieNode root, node;
    public Trie() {
        root = new TrieNode(null);
    }
    
    public void insert(String path, String content) {
        node = getTargetNode(path);
        if (content != null) node.content = node.content == null ? content : node.content + content;
    }
    
    public String getContent(String path) {
        node = getTargetNode(path);
        // trying to read content from file
        return node.content;
    }
    
    public List<String> ls(String path) {
        List<String> ans = new ArrayList<String>();
        node = getTargetNode(path);
        // if it is a file
        if (node.content != null) {
            ans.add(node.name);
            return ans;
        }
        // if it is a folder
        for (String dir : node.children.keySet()) {
            ans.add(dir);
        }
        // lexicographic order
        Collections.sort(ans);
        return ans;
    }
    
    private TrieNode getTargetNode(String path) {
        node = root;
        for (String folder : path.split("/")) {
            if (folder.isEmpty() || folder.equals("")) continue;
            if (node.children.get(folder) == null) {
                TrieNode newNode = new TrieNode(folder);
                node.children.put(folder, newNode);
                node = newNode;
            } else {
                node = node.children.get(folder);
            }
        }
        return node;
    }

}

class TrieNode {
    Map<String, TrieNode> children = new HashMap<String, TrieNode>();
    String name;
    String content;
    public TrieNode(String name){
        this.name = name;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */