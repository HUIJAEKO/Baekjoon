import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        int[] count = new int[10];
        
        for(int i=0; i<priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
            count[priorities[i]]++;
        }
        
        int max = 9;
        while(count[max] == 0 && max > 0) {
            max--;
        }
        
        int order = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int n = cur[0];
            int idx = cur[1];
            
            if(n < max) {
                q.offer(cur);
                continue;
            }
            
            order++;
            if(idx == location) {
                return order;
            }
            
            count[n]--;
            while(count[max] == 0 && max > 0) {
                max--;
            }
        }
        
        return -1;
    }
}