class Solution {
    public int solution(int[] players, int m, int k) {
        
        int answer = 0;
        int active = 0;
        int[] expire = new int[24 + k];

        for (int i = 0; i < players.length; i++) {
            
            active -= expire[i];
            int required = players[i] / m;
            
            if (required > active) {
                int add = required - active;
                answer += add;
                active += add;
                
                expire[i + k] += add;
            }
        }
        
        return answer;
    }
}