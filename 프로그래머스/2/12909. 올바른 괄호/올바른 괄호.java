class Solution {
    boolean solution(String s) {
        int balance = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);   
            
            if(c == '(') {
                balance++;
            } else {
                balance--;
                if(balance < 0) {
                    return false;
                }
            }
        }
        
        return balance == 0;
    }
}