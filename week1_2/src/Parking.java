import java.util.*;

public class Parking {
    String[] arr = new String[10];

    int park(String p) {
        int i = Math.abs(p.hashCode()) % 10;
        while (arr[i] != null) i = (i + 1) % 10;
        arr[i] = p;
        return i;
    }

    public static void main(String[] args) {
        Parking p = new Parking();
        System.out.println(p.park("ABC"));
        System.out.println(p.park("XYZ"));
    }
}