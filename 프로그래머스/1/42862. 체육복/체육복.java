import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] p = new int[n+2];
        Arrays.fill(p, 1);
        
        for (int l : lost) {
            p[l]--;
        }
        
        for (int r : reserve) {
            p[r]++;
        }
        
        for (int i=1; i<=n; i++) {
            if (p[i] == 0) {
                if (p[i-1] == 2) {
                    p[i]++;
                    p[i-1]--;
                } else if (p[i+1] == 2) {
                    p[i]++;
                    p[i+1]--;
                }
            }
        }
        
        int answer = 0;
        for (int i=1; i<=n; i++) {
            if (p[i] >= 1) {
                answer++;
            }
        }
        
        return answer;
    }
}