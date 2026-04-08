import java.util.*;

public class DNSCache {
    class Entry {
        String ip;
        long exp;
        Entry(String i, long t) {
            ip = i;
            exp = System.currentTimeMillis() + t;
        }
    }

    HashMap<String, Entry> map = new HashMap<>();

    String resolve(String d) {
        Entry e = map.get(d);
        if (e != null && System.currentTimeMillis() < e.exp) return e.ip;
        String ip = "1.1.1.1";
        map.put(d, new Entry(ip, 3000));
        return ip;
    }

    public static void main(String[] args) {
        DNSCache d = new DNSCache();
        System.out.println(d.resolve("google.com"));
        System.out.println(d.resolve("google.com"));
    }
}
