import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = 100001; 
        boolean[] visited = new boolean[max];

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{N, 0}); 

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int position = current[0];
            int time = current[1];

            if (position == K) {
                System.out.println(time);
                return;
            }

            visited[position] = true;

            if (position * 2 < max && !visited[position * 2]) {
                deque.addFirst(new int[]{position * 2, time}); 
            }

            if (position + 1 < max && !visited[position + 1]) {
                deque.addLast(new int[]{position + 1, time + 1});
            }

            if (position - 1 >= 0 && !visited[position - 1]) {
                deque.addLast(new int[]{position - 1, time + 1});
            }
        }
    }
}
