import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        ArrayList<String> arr = new ArrayList<>(map.keySet());
        arr.sort((a, b) -> {
            if(map.get(a) != map.get(b)){
                return map.get(b) - map.get(a);
            }

            return a.compareTo(b);
        });

        System.out.println(arr.get(0));
    }
}
