import java.util.*;

class Solution { 
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for(int i=0; i<survey.length; i++){
            String s = survey[i];
            int select = choices[i];
            
            int score = Math.abs(select-4);
            if(select > 4){
                map.put(s.charAt(1), map.get(s.charAt(1)) + score);
            }else{
                map.put(s.charAt(0), map.get(s.charAt(0)) + score);
            }
        }   
        
        StringBuilder sb = new StringBuilder();
        sb.append(map.get('R') >= map.get('T') ? "R" : "T");
        sb.append(map.get('C') >= map.get('F') ? "C" : "F");
        sb.append(map.get('J') >= map.get('M') ? "J" : "M");
        sb.append(map.get('A') >= map.get('N') ? "A" : "N");
        
        return sb.toString();
    }   
}