import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static Queue<int[]> queue;
    static int[][] matrix;
    static boolean[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if(matrix[i][j] == 1){
                    queue.add(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        int max = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int day = current[2];

            max = Math.max(day, max);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && matrix[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    matrix[nx][ny] = 1;
                    queue.add(new int[]{nx, ny, day + 1});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    return -1;
                }
            }
        }

        return max;
    }
}
