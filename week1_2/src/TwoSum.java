import java.util.*;

public class TwoSum {
    static void find(int[] a, int t) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i : a) {
            if (m.containsKey(t - i))
                System.out.println(i + " " + (t - i));
            m.put(i, 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {2,3,7,5};
        find(a, 10);
    }
}
