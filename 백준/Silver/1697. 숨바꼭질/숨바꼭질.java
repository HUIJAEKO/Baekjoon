import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();

        boolean[] visited = new boolean[100001];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N,0});
        visited[N] = true;

        while(!queue.isEmpty()) {
            int[] prev = queue.poll();

            if (prev[0] == K) {
                System.out.println(prev[1]);
                return;
            }

            int[] nextPositions = {prev[0] * 2, prev[0] + 1, prev[0] - 1};
            for (int nextPos : nextPositions) {
                if (nextPos >= 0 && nextPos <= 100000 && !visited[nextPos]) {
                    queue.offer(new int[]{nextPos, prev[1] + 1});
                    visited[nextPos] = true;
                }
            }
        }
    }
}
