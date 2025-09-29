import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Robot {
    private static final Set<String> usedNames = new HashSet<>();
    private static final Random random = new Random();

    private String name;

    public String getName() {
        if (name == null) {
            name = generateUniqueName();
        }
        return name;
    }

    public void reset() {
        if (name != null) {
            usedNames.remove(name);
            name = null;
        }
    }

    private String generateUniqueName() {
        String newName;
        do {
            newName = generateRandomName();
        } while (usedNames.contains(newName));
        usedNames.add(newName);
        return newName;
    }

    private String generateRandomName() {
        char first = (char) ('A' + random.nextInt(26));
        char second = (char) ('A' + random.nextInt(26));
        int number = random.nextInt(1000); // 000 to 999
        return String.format("%c%c%03d", first, second, number);
    }
}