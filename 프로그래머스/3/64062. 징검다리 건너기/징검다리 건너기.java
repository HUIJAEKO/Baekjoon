class Solution {
    public int solution(int[] stones, int k) {
        int left = 0;
        int right = 200000000;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    static boolean canCross(int[] stones, int k, int mid) {
        int count = 0;
        
        for (int stone : stones) {
            if (stone < mid) {
                count++;
                if (count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        
        return true;
    }    
}