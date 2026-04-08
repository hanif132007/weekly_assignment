import java.util.*;

public class RateLimiter {
    HashMap<String, Integer> map = new HashMap<>();

    boolean allow(String id) {
        int c = map.getOrDefault(id, 0);
        if (c < 5) {
            map.put(id, c + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        RateLimiter r = new RateLimiter();
        for (int i = 0; i < 7; i++)
            System.out.println(r.allow("user"));
    }
}