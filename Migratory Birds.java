import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);
        }
        
        System.out.println(findMostCommon(countMap));
    }

    static int findMostCommon(Map<Integer, Integer> map) {
        int maxCount = 0, minId = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount || (entry.getValue() == maxCount && entry.getKey() < minId)) {
                maxCount = entry.getValue();
                minId = entry.getKey();
            }
        }
        
        return minId;
    }
}
