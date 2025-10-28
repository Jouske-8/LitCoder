import java.util.Scanner;
import java.util.Stack;

public class Main {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor
    public Main() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation
    public void dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            stack2.pop();
        }
    }

    // Print front operation
    public Integer front() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? null : stack2.peek();
    }

    public static void main(String[] args) {
        Main queue = new Main();
        Scanner scanner = new Scanner(System.in);

      //  System.out.println("Enter commands (1 x for enqueue, 2 for dequeue, 3 for front):");
        String input = scanner.nextLine();

        // Split the input by comma
        String[] commands = input.split(",");

        // Process each command
        for (String command : commands) {
            String[] parts = command.trim().split(" ");
            int operation = Integer.parseInt(parts[0]);

            switch (operation) {
                case 1: // Enqueue
                    int value = Integer.parseInt(parts[1]);
                    queue.enqueue(value);
                    break;
                case 2: // Dequeue
                    queue.dequeue();
                    break;
                case 3: // Print Front
                    Integer frontValue = queue.front();
                    if (frontValue != null) {
                        System.out.println(frontValue);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                default:
                    System.out.println("Invalid operation. Please enter 1 for enqueue, 2 for dequeue or 3 for front.");
            }
        }

        scanner.close();
    }
}
