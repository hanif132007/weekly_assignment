import java.util.*;

public class UsernameChecker {

    private HashMap<String, Integer> users;
    private HashMap<String, Integer> attempts;

    public UsernameChecker() {
        users = new HashMap<>();
        attempts = new HashMap<>();
    }

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        users.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            suggestions.add(username + i);
        }

        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    public String getMostAttempted() {
        String maxUser = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : attempts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxUser = entry.getKey();
            }
        }
        return maxUser + " (" + maxCount + " attempts)";
    }

    public static void main(String[] args) {
        UsernameChecker system = new UsernameChecker();
        Scanner sc = new Scanner(System.in);

        system.registerUser("john_doe", 1);
        system.registerUser("admin", 2);

        while (true) {
            System.out.println("\n1. Check Username");
            System.out.println("2. Register Username");
            System.out.println("3. Suggest Alternatives");
            System.out.println("4. Most Attempted Username");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String u1 = sc.nextLine();
                    boolean available = system.checkAvailability(u1);
                    if (available)
                        System.out.println("Available");
                    else
                        System.out.println("Not Available");
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String u2 = sc.nextLine();
                    System.out.print("Enter userId: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (system.checkAvailability(u2)) {
                        system.registerUser(u2, id);
                        System.out.println("Registered successfully");
                    } else {
                        System.out.println("Username already taken");
                    }
                    break;

                case 3:
                    System.out.print("Enter username: ");
                    String u3 = sc.nextLine();
                    List<String> list = system.suggestAlternatives(u3);
                    System.out.println("Suggestions: " + list);
                    break;

                case 4:
                    System.out.println("Most Attempted: " + system.getMostAttempted());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}