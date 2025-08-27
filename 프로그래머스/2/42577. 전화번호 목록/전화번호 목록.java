import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        ArrayList<String> arr = new ArrayList<>();
        
        for(String s : phone_book) {
            arr.add(s);
        }
        
        Collections.sort(arr);
        
        for(int i=0; i<arr.size()-1; i++) {
            if(arr.get(i+1).startsWith(arr.get(i))) {
                return false;
            }
        }
        
        return true;
    }
}