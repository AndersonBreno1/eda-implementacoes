public class FIFOCachePolicy implements CachePolicy {

    private CircularQueue queue;

    public FIFOCachePolicy(int capacity) {
        queue = new CircularQueue(capacity);
    }
 
    public String get(int key) {
        Pair p = queue.get(key);
        if (p == null) {
            System.out.println("miss " + key);
            return null;    
        }
        
        System.out.println("hit " + key);
        
        return p.getValue();
    }

    public void put(int key, String value) {
        Pair p = this.queue.get(key);
        if (p == null) {
            if (queue.isFull()) {
                queue.removeFirst();
            }
            queue.addLast(new Pair(key,  value));
        }
    }

    public String toString() {
        return this.queue.toString();
    }

    public static void main(String[] args) {
        FIFOCachePolicy cache = new FIFOCachePolicy(3);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");

        cache.get(1);
        cache.get(2);
        cache.get(3);
        System.out.println(cache);

        cache.put(4, "d");
        cache.get(1);
        System.out.println(cache);
    
    }

}
