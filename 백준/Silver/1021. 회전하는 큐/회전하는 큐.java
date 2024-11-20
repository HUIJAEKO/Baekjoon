import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int total = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());

            int index = 0;
            for(int element : deque) {
                if (element == target) {
                    break;
                }
                index++;
            }

            int left = index;
            int right = deque.size() - index;

            if(left <= right){
                for(int j=0; j<left; j++){
                    deque.addLast(deque.removeFirst());
                    total++;
                }
            }else{
                for(int j=0; j<right; j++){
                    deque.addFirst(deque.removeLast());
                    total++;
                }
            }

            deque.removeFirst();
        }
        System.out.println(total);
    }
}
