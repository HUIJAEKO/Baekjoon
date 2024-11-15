import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();

        matrix = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String line = input.next();
            for(int j=0; j<M; j++){
                matrix[i][j] = line.charAt(j) - '0';
            }
        }

        minimum(0,0);
        System.out.println(matrix[N-1][M-1]);
    }

    public static void minimum(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a,b});
        visited[a][b] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(x>=0 && y>=0 && x<N && y<M){
                    if(matrix[x][y]==1 && !visited[x][y]){
                        visited[x][y] = true;
                        matrix[x][y] = matrix[now[0]][now[1]] + 1;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
        }
    }
}
