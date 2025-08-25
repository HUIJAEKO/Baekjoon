import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] days = new int[n];
        
        for(int i=0; i<n; i++) {
            int remain = 100 - progresses[i];
            days[i] = (remain + speeds[i] - 1) / speeds[i];
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        int cnt = 1;
        int curr = days[0];
        for(int i=1; i<n; i++) {
            if(days[i] <= curr) {
                cnt++;
            } else {
                arr.add(cnt);
                curr = days[i];
                cnt = 1;
            }
        }
        arr.add(cnt);
        
        return arr;
    }     
}