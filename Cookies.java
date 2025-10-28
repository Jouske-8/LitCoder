 import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetSweetness = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Read the candies' sweetness levels
        while (sc.hasNextInt()) {
            pq.offer(sc.nextInt());
        }

        System.out.println(minStepsToTargetSweetness(pq, targetSweetness));
    }

    public static int minStepsToTargetSweetness(PriorityQueue<Integer> pq, int targetSweetness) {
        int steps = 0;

        // Continue combining candies until we reach or exceed the target sweetness
        while (pq.size() > 1 && pq.peek() < targetSweetness) {
            int leastSweet = pq.poll();
            int secondLeastSweet = pq.poll();
            int newCandy = leastSweet + 2 * secondLeastSweet;
            pq.offer(newCandy);
            steps++;
        }

        // Check if the sweetness of the resulting candies meets the target
        return pq.peek() >= targetSweetness ? steps : -1;
    }
}