import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int k) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(!uniqueNumbers.contains(arr[i])) {
                uniqueNumbers.add(arr[i]);
                answer.add(arr[i]);
            }
            if(answer.size() == k) {
                break;
            }
        }
        
        while(answer.size()<k){
            answer.add(-1);
        }
        
        return answer;
    }
}