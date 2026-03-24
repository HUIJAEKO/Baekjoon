import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int total = 0;
        
        for (int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            int weight = cost[2];
            
            if (find(parent, start) != find(parent, end)) {
                union(parent, start, end);
                total += weight;
            }
        }
        
        return total;
    }
    
    static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        } 
        
        return find(parent, parent[x]);
    }
    
    static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}