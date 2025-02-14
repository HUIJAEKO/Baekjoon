import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++){
            set1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<B; i++){
            set2.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;

        for(int num : set1){
            if(!set2.contains(num)){
                count++;
            }
        }

        for(int num : set2){
            if(!set1.contains(num)){
                count++;
            }
        }

        System.out.println(count);
    }
}
