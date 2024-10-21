import java.util.*;

class Solution {
    public List<Integer> solution(int[] num_list) {
        List<Integer> answer = new ArrayList<>();
        
        for(int num : num_list){
            answer.add(num);
        }
        
        if(num_list[num_list.length-1] > num_list[num_list.length-2]){
            answer.add(num_list[num_list.length-1] - num_list[num_list.length-2]);
        }else{
            answer.add(num_list[num_list.length-1] * 2);
        }
        
        return answer;
    }
}