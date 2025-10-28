import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CustomStack {
    private final StringBuilder text = new StringBuilder();
    private final List<Command> history = new ArrayList<>();

    // Command class to store operations for undo functionality
    private static class Command {
        int type; // 1: insert, 2: delete
        String value;

        Command(int type, String value) {
            this.type = type;
            this.value = value;
        }
    }

    public void insert(String value) {
        text.append(value); // Insert text at the end
        history.add(new Command(1, value)); // Log the insert operation
    }

    public void delete(int value) {
        int lengthBeforeDelete = text.length();
        if (lengthBeforeDelete > 0) {
            // Calculate the number of characters to delete
            int charsToDelete = Math.min(value, lengthBeforeDelete);
            String deleted = text.substring(lengthBeforeDelete - charsToDelete);
            text.delete(lengthBeforeDelete - charsToDelete, lengthBeforeDelete); // Delete characters
            history.add(new Command(2, deleted)); // Log the delete operation
        }
    }

    public String get(int value) {
        // Returns character at the specified index (1-indexed)
        return value - 1 < text.length() ? String.valueOf(text.charAt(value - 1)) : "";
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.remove(history.size() - 1);
            if (lastCommand.type == 1) {
                // Undo insert
                text.delete(text.length() - lastCommand.value.length(), text.length());
            } else if (lastCommand.type == 2) {
                // Undo delete
                text.append(lastCommand.value); // Reinsert deleted text
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomStack editor = new CustomStack();

        // Example input handling
        String[] commands = scanner.nextLine().split(",");
        for (String command : commands) {
            String[] parts = command.trim().split(" ");
            int cmdType = Integer.parseInt(parts[0]);

            switch (cmdType) {
                case 1: // Insert operation
                    editor.insert(parts[1]);
                    break;
                case 2: // Delete operation
                    int deleteCount = Integer.parseInt(parts[1]);
                    editor.delete(deleteCount);
                    break;
                case 3: // Get operation
                    int index = Integer.parseInt(parts[1]);
                    String charAt = editor.get(index);
                    if (!charAt.isEmpty()) {
                        System.out.println(charAt); // Print on a new line
                    }
                    break;
                case 4: // Undo operation
                    editor.undo();
                    break;
            }
        }

        scanner.close();
    }
}
