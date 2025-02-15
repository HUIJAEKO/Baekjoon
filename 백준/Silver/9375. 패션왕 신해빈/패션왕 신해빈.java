import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for(int j=0; j<n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();

                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            int total = 1;
            for(int value : map.values()){
                total *= (value + 1);
            }

            System.out.println(total - 1);
        }
    }
}
