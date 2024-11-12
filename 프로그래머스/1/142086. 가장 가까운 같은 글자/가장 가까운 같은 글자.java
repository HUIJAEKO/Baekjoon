import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        String[] str = s.split("");
        List<String> dup = new ArrayList<>();
        int step = 1;
        
        for(int i=0; i<str.length; i++){
            if(!dup.contains(str[i])){
                answer.add(-1);
                dup.add(str[i]);
            }else{
                for(int j=i-1; j>=0; j--){
                    if(!str[i].equals(str[j])){
                        step++;
                    }else{
                        answer.add(step);
                        step = 1;
                        break;
                    }
                }
            }
        }
        return answer;
        
    }
}