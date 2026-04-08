import java.util.*;

public class Analytics {
    HashMap<String, Integer> views = new HashMap<>();

    void add(String url) {
        views.put(url, views.getOrDefault(url, 0) + 1);
    }

    public static void main(String[] args) {
        Analytics a = new Analytics();
        a.add("page1");
        a.add("page1");
        a.add("page2");
        System.out.println(a.views);
    }
}
