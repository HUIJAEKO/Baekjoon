import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> newArr = new ArrayList<>();
        
        for (String str : strArr) {
            if (!str.contains("ad")) {
                newArr.add(str);
            }
        }
        
        return newArr.toArray(new String[0]);
    
    }
}