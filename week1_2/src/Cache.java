import java.util.*;

public class Cache {
    HashMap<String, String> L1 = new HashMap<>();
    HashMap<String, String> L2 = new HashMap<>();
    HashMap<String, String> L3 = new HashMap<>();

    String get(String k) {
        if (L1.containsKey(k)) return L1.get(k);
        if (L2.containsKey(k)) {
            L1.put(k, L2.get(k));
            return L2.get(k);
        }
        if (L3.containsKey(k)) {
            L2.put(k, L3.get(k));
            return L3.get(k);
        }
        return null;
    }

    public static void main(String[] args) {
        Cache c = new Cache();
        c.L3.put("v1", "data");
        System.out.println(c.get("v1"));
        System.out.println(c.get("v1"));
    }
}