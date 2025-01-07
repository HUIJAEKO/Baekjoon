import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static Queue<int[]> q = new LinkedList<>();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int lastCount = 0;
        int time = 0;

        while(true){
            int count = countCheese();
            if(count == 0){
                break;
            }

            lastCount = count;
            melt();
            time++;
        }

        System.out.println(time);
        System.out.println(lastCount);
    }

    static int countCheese() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    static void melt() {
        visited = new boolean[N][M];
        q = new LinkedList<>();
        q.add(new int[]{0, 0}); 
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] prev = q.poll();
            int x = prev[0];
            int y = prev[1];

            for(int i=0; i<4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX >= 0 && newX < N && newY >= 0 && newY < M && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    
                    if(matrix[newX][newY] == 1){
                        matrix[newX][newY] = 0;
                    }else{
                        q.add(new int[]{newX,newY});
                    }
                }
            }
        }
    }
}
