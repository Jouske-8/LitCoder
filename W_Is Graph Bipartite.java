import java.util.*;

public class Main {
    
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length; // Number of nodes
        int[] color = new int[n]; // Array to store colors of nodes; 0 means uncolored
        
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) { // If the node is uncolored
                if (!bfs(graph, color, i)) {
                    return false; // If bipartite check fails
                }
            }
        }
        return true; // All components checked and are bipartite
    }
    
    private static boolean bfs(int[][] graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1; // Start coloring with color 1
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) { // If uncolored, color with opposite color
                    color[neighbor] = -color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) { // If the same color, not bipartite
                    return false;
                }
            }
        }
        return true; // No conflicts found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of nodes
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline

        // Read the graph input
        int[][] graph = new int[n][];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().trim().split(" ");
            graph[i] = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        // Check if the graph is bipartite
        boolean result = isBipartite(graph);
        System.out.println(result);

        scanner.close();
    }
}