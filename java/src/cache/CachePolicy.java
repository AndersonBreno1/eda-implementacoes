public interface CachePolicy {

    public String get(int key);
    public void put(int key, String value);

}
