import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for(int i=0; i<players.length; i++){
            rank.put(players[i], i);
        }
        
        for(String calling : callings){
            int curRank = rank.get(calling);
            String prev = players[curRank - 1];
            
            players[curRank - 1] = calling;
            players[curRank] = prev;

            rank.put(calling, curRank - 1);
            rank.put(prev, curRank);
        }
        
        return players;
    }
}