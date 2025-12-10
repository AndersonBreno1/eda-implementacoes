public class Asserts {
    
    public static void main(String[] args) {

        FIFOCachePolicy cache = new FIFOCachePolicy(3);
        assert cache.get(1) == null;
        assert cache.get(2) == null;
        assert cache.get(3) == null;
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");

        assert cache.get(1).equals("a");
        assert cache.get(2).equals("b");
        assert cache.get(3).equals("c");

        cache.put(4, "d");
        assert cache.get(1) == null;

        cache.put(5, "f");
        assert cache.get(2) == null;

        cache.put(6, "g");
        assert cache.get(3) == null;
        
        assert cache.get(4).equals("d");
        assert cache.get(5).equals("f");
        assert cache.get(6).equals("g");
    }

}
