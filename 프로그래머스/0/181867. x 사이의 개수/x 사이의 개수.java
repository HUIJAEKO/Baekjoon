import java.util.*;

class Solution {
    public int[] solution(String myString) {
        String[] str = myString.split("x",-1);
        int[] result = new int[str.length];
        
        for (int i = 0; i < str.length; i++) {
            result[i] = str[i].length();
        }
        
        return result;
    }
}