public class FIFOCachePolicy implements CachePolicy {

    private CircularQueue queue;

    public FIFOCachePolicy(int capacity) {
        queue = new CircularQueue(capacity);
    }
 
    // TODO implementar
    public String get(int key) {
        return null;
    }

    // TODO implementar
    public void put(int key, String value) {
    }

    public String toString() {
        return this.queue.toString();
    }
}
