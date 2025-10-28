 import java.util.Scanner;

public class Main {
    
    // DFS function to mark all cities connected to city i
    public static void dfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true; // Mark the current city as visited
        
        // Iterate over all cities and perform DFS on unvisited, connected cities
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j); // Recursive DFS call
            }
        }
    }
    
    // Function to find the number of provinces
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // Number of cities
        boolean[] visited = new boolean[n]; // To track visited cities
        int provinceCount = 0; // Count of provinces
        
        // Perform DFS for every unvisited city
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i); // Explore all cities in this province
                provinceCount++; // Increment province count
            }
        }
        
        return provinceCount; // Return the total number of provinces
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of cities
        int[][] isConnected = new int[n][n]; // Matrix to store connectivity

        // Reading the matrix input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isConnected[i][j] = sc.nextInt();
            }
        }
        
        // Calling the function to find number of provinces
        int result = findCircleNum(isConnected);
        
        // Output the result
        System.out.println(result);
    }
}