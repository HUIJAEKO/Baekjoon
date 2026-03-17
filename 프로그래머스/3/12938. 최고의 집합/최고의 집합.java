import java.util.*;

class Solution {
    public int[] solution(int n, int s) {        
        if (s < n) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        int b = s / n;
        int e = s % n;
        
        for (int i = 0; i < n; i++) {
            answer[i] = b;
        }
        
        for (int i = n - e; i < n; i++) {
            answer[i]++;
        }
        
        return answer;
    }
}