import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalMap = new HashMap<>();
        Map<String, List<int[]>> map = new HashMap<>();
        
        // 장르별 재생 수, 누적 재생 수 저장
        for (int i = 0; i < genres.length; i++) {
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
            
            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        // 누적 재생 수 기준으로 장르 정렬
        List<String> genreList = new ArrayList<>(totalMap.keySet());
        genreList.sort((a, b) -> totalMap.get(b) - totalMap.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        // 장르별 처리
        for (String genre : genreList) {
            List<int[]> list = map.get(genre);
            
            // 같은 장르 내 재생 수 기준 정렬
            list.sort((a, b) -> {
                if(a[1] == b[1]) {
                    return a[0] - b[0];
                }
                
                return b[1] - a[1];
            });
                
            // 최대 2개
            result.add(list.get(0)[0]);
            if(list.size() > 1) {
                result.add(list.get(1)[0]);
            }
        }
        
        // 배열 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}