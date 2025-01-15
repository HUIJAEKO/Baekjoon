import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());

            if(min.isEmpty() || min.peek() >= n){
                min.add(n);
            }else{
                max.add(n);
            }

            if(min.size() > max.size() + 1){
                max.offer(min.poll());
            }else if(max.size() > min.size()){
                min.offer(max.poll());
            }

            sb.append(min.peek()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
