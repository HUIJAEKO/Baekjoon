import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);
            
            while (k > 0 && !stack.isEmpty() && stack.peek() < cur) {
                stack.pop();
                k--;
            }
            stack.push(cur);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}