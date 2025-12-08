import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});
        int answer = 0;
        
        while (!stack.isEmpty()) {
            int[] prev = stack.pop();
            int idx = prev[0];
            int sum = prev[1];
            
            if (idx == numbers.length) {
                if (sum == target) {
                    answer++;
                }
                continue;
            }
            
            stack.push(new int[]{idx + 1, sum + numbers[idx]});
            stack.push(new int[]{idx + 1, sum - numbers[idx]});
        }
        
        return answer;
    }
}