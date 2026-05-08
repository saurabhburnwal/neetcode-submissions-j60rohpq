class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node left;
    Node right;

    private class Node {
        private int key;
        private int val;
        private Node prev;
        private Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        left = new Node(0, 0);
        right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node) {
        Node prev = this.right.prev;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
        prev.next = node;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        remove(cache.get(key));
        insert(cache.get(key));
        return cache.get(key).val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);
        if (cache.size() > capacity) {
            Node tmp = this.left.next;
            remove(tmp);
            cache.remove(tmp.key);
        }
    }
}
