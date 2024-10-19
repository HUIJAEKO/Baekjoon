import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> numArr = new ArrayList<>();
    
        for(int num : arr){
            for(int i=0; i<num; i++){
                numArr.add(num);
            }        
        }
        
        int[] result = new int[numArr.size()];
        for (int i = 0; i < numArr.size(); i++) {
            result[i] = numArr.get(i);
        }
        
        return result;
    }
}