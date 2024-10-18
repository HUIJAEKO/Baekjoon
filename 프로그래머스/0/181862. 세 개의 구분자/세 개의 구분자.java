import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] arr = myStr.split("[abc]");
        List<String> li = new ArrayList<>();
        
        for(String arrs : arr){
            if(!arrs.isEmpty()){
                li.add(arrs);
            }
        }
        
        if(li.isEmpty()){
            return new String[]{"EMPTY"};
        }
        
        return li.toArray(new String[0]);
    }
}

