import java.util.*;

public class Plagiarism {
    HashMap<String, Set<String>> map = new HashMap<>();

    List<String> grams(String t) {
        String[] w = t.split(" ");
        List<String> l = new ArrayList<>();
        for (int i = 0; i < w.length - 2; i++)
            l.add(w[i] + " " + w[i+1] + " " + w[i+2]);
        return l;
    }

    void add(String id, String t) {
        for (String g : grams(t)) {
            map.putIfAbsent(g, new HashSet<>());
            map.get(g).add(id);
        }
    }

    public static void main(String[] args) {
        Plagiarism p = new Plagiarism();
        p.add("doc1", "this is sample text data");
        p.add("doc2", "this is sample text again");
        System.out.println("Processed");
    }
}