import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 2) {
                result.add(key);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}
