import java.util.*;

public class InventoryManager {
    HashMap<String, Integer> stock = new HashMap<>();
    HashMap<String, Queue<Integer>> wait = new HashMap<>();

    synchronized String buy(String p, int u) {
        int s = stock.getOrDefault(p, 0);
        if (s > 0) {
            stock.put(p, s - 1);
            return "Success";
        } else {
            wait.putIfAbsent(p, new LinkedList<>());
            wait.get(p).add(u);
            return "Waitlist #" + wait.get(p).size();
        }
    }

    public static void main(String[] args) {
        InventoryManager m = new InventoryManager();
        m.stock.put("item", 2);
        System.out.println(m.buy("item", 1));
        System.out.println(m.buy("item", 2));
        System.out.println(m.buy("item", 3));
    }
}