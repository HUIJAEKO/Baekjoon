import java.util.*;

class Solution {
    int best = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] used = new boolean[dungeons.length];
        dfs(k, dungeons, used, 0);
        return best;

    }
    
    void dfs(int k, int[][] dungeons, boolean[] used, int count) {
        best = Math.max(best, count);
        
        if(count == dungeons.length) {
            return;
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if(used[i]) {
                continue;
            }
            
            int min = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(k < min) {
                continue;
            }
            
            used[i] = true;
            dfs(k - cost, dungeons, used, count + 1);
            used[i] = false;
        }
    }
}