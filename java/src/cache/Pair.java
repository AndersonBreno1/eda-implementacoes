public class Pair {

    private int key;
    private String value;

    public Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return this.key + "->" + this.value;
    }

    public boolean equals(Pair p) {
        return p.key == this.key;
    }

}
