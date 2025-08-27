import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville) {
            pq.offer(s);
        }
        
        int i=0;
        while(pq.size() >= 2 && pq.peek() < K) {
            i++;
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b * 2);
        }
        
        return (!pq.isEmpty() && pq.peek() >= K) ? i : -1;
    }
}