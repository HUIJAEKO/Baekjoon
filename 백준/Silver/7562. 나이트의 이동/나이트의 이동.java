import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = new int[]{-2, 2, 1, -1, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0 ) {
            int len = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[len][len];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{cx, cy, 0});
            visited[cx][cy] = true;

            while (!q.isEmpty()) {
                int[] prev = q.poll();
                int x = prev[0];
                int y = prev[1];
                int cnt = prev[2];

                if (x == px && y == py) {
                    System.out.println(cnt);
                    break;
                }

                for (int i=0; i<8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < len && ny >= 0 && ny < len && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, cnt + 1});
                    }
                }
            }
        }
    }
}
