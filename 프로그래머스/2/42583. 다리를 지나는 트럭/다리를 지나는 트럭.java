import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int idx = 0;
        int curWeight = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);    
        }
        
        while (idx < truck_weights.length) {
            time++;
            curWeight -= bridge.poll();
            
            int next = truck_weights[idx];
            if (next + curWeight <= weight) {
                bridge.offer(next);
                curWeight += next;
                idx++;
            } else {
                bridge.offer(0);
            }
        }
        
        return time + bridge_length;
    }
}