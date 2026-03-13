class Solution {
    public int solution(int[] cookie) {
        int len = cookie.length;
        int answer = 0;
        
        for (int i = 0; i < len - 1; i++) {
            int left  = i;
            int right = i + 1;
            
            int leftSum = cookie[left];
            int rightSum = cookie[right];
            
            while (true) {
                if (leftSum == rightSum) {
                    answer = Math.max(answer, leftSum);
                }
                
                if (leftSum <= rightSum) {
                    left--;
                    if (left < 0) break;
                    leftSum += cookie[left];
                } else {
                    right++;
                    if (right >= len) break;
                    rightSum += cookie[right];
                }
            }
        }
        
        return answer;
    }
}