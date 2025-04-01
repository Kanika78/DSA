class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head;
    Node tail;
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key , int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public LRUCache(int capacity) {
        this.head = new Node(-1 , -1);
        this.tail = new Node(-1 , -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            delete(map.get(key));
            insert(map.get(key));
            return map.get(key).val;
        }
        return -1;

        
    }
    public void insert(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head; 
    }
    public void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            delete(map.get(key));
            insert(map.get(key));
        }
        else if(map.size() == capacity){
            int k = tail.prev.key;
            delete(map.get(k));
            map.remove(k);
            map.put(key , new Node(key , value));
            insert(map.get(key));
        }
        else{
            map.put(key , new Node(key , value));
            insert(map.get(key));
        }  
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */