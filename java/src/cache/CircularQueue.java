public class CircularQueue {

    private int head;
    private int tail;
    private int capacity;
    private Pair[] queue;

    public CircularQueue(int capacity) {
        this.head = -1;
        this.tail = -1;
        this.capacity = capacity;
        this.queue = new Pair[capacity];
    }
    
    public boolean isEmpty() {
        return this.head == -1;
    }

    public boolean isFull() {
        return ((this.tail + 1) % this.capacity) == this.head;
    }

    public boolean addLast(Pair pair) {
        if (isEmpty()) {
            this.head = 0;
            this.tail = 0;
            this.queue[tail] = pair;
            return true;
        } else if (isFull()) {
            return false;
        } else {
            this.tail = (this.tail + 1) % capacity;
            this.queue[tail] = pair;
            return true;
        }

    }

    public Pair removeFirst() {
        if (isEmpty()) return null;
        
        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
            return this.queue[0];
        } else {
            Pair p = this.queue[this.head];
            this.head = (this.head + 1) % capacity;
            return p;
        }
    }

    public String toString() {
        if (isEmpty()) return "empty!";
        int h = this.head;
        String out = "";
        while (h != this.tail ) {
            out += this.queue[h] + " ";
            h = (h + 1) % capacity;
        }
        return out + this.queue[h];
    }

    public boolean contains(int key) {
        if (isEmpty()) return false;
        int h = this.head;
        while (h != this.tail) {
            if (this.queue[h].getKey() == key) return true;
            h = (h + 1) % capacity;
        }

        if (this.queue[h].getKey() == key) return true;
        return false;
    }

    public Pair get(int key) {
        if (isEmpty()) return null;
        int h = this.head;
        while (h != this.tail) {
            if (this.queue[h].getKey() == key) return this.queue[h];
            h = (h + 1) % capacity;
        }

        if (this.queue[h].getKey() == key) return this.queue[h];
        return null;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        assert !queue.contains(1);
        queue.addLast(new Pair(1, "a"));        
        assert queue.contains(1);
        queue.addLast(new Pair(2, "b"));        
        assert queue.contains(2);
        queue.addLast(new Pair(3, "c"));        
        assert queue.contains(3);

        queue.removeFirst();
        assert !queue.contains(1);
        queue.addLast(new Pair(4, "d"));
        assert queue.contains(4);

        queue.removeFirst();
   
        assert !queue.contains(2);
        queue.addLast(new Pair(1, "a"));

        assert queue.contains(1);


        System.out.println(queue);




    }

}
