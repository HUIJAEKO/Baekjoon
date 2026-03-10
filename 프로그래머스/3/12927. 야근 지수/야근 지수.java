import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            pq.offer(work);
        }
        
        while (n-- > 0) {
            int cur = pq.poll();
            
            if (cur == 0) {
                return 0;
            } 
            
            pq.offer(cur - 1);
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            answer += cur * cur;
        }
        
        return answer;
    }
}