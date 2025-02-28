import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(word.length() >= M){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        ArrayList<String> result = new ArrayList<>(map.keySet());
        result.sort((a, b) -> {
           if(!Objects.equals(map.get(a), map.get(b))){
               return map.get(b) - map.get(a);
           }

           if(a.length() != b.length()){
               return b.length() - a.length();
           }

           return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for(String str : result){
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
