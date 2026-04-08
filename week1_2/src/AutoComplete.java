import java.util.*;

public class AutoComplete {
    HashMap<String, Integer> map = new HashMap<>();

    void add(String s) {
        map.put(s, map.getOrDefault(s, 0) + 1);
    }

    public static void main(String[] args) {
        AutoComplete a = new AutoComplete();
        a.add("java");
        a.add("javascript");
        System.out.println(a.map);
    }
}