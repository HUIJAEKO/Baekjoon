class Solution {
    public int solution(int[] numbers, int n) {
        int i=0, answer=0;
        while(answer<=n){
            answer+=numbers[i++];
        }
        return answer;
    }
}