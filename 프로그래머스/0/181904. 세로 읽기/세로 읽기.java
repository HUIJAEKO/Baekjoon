class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        int i=c-1;
        while(i<my_string.length()){
            sb.append(my_string.charAt(i));
            i+=m;
        }
        return sb.toString();
    }
}