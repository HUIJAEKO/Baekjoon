import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String bool = st.nextToken();

            if(bool.equals("enter")){
                map.put(name, 1);
            }else{
                map.put(name, 0);
            }
        }

        ArrayList<String> arr = new ArrayList<>();
        for(String name : map.keySet()){
            if(map.get(name) == 1){
                arr.add(name);
            }
        }

        Collections.sort(arr, Collections.reverseOrder());
        for(String name : arr){
            System.out.println(name);
        }
    }
}
