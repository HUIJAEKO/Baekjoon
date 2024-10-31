public class Solution {
    public int solution(String s) {
        int answer = 0;
        int i = 0;
        while (i < s.length()) {
            char a = s.charAt(i);
            int x = 0; 
            int other = 0; 
            while (i < s.length()) {
                if (s.charAt(i) == a) {
                    x++;
                } else {
                    other++;
                }
                i++;
                if (x == other) {
                    answer++;
                    break;
                }
                if(i==s.length() && x!=other){
                    answer++;
                }
            }
        }
        return answer;
    }
}
