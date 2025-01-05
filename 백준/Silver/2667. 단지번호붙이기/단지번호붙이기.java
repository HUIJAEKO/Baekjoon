import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String[] num = br.readLine().split("");

            for(int j=0; j<N; j++){
                matrix[i][j] = Integer.parseInt(num[j]);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    arr.add(find(i,j));
                }
            }
        }

        Collections.sort(arr);
        System.out.println(arr.size());
        for(int n : arr){
            System.out.println(n);
        }
    }

    static int find(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        int count = 0;

        while(!queue.isEmpty()){
            int[] prev = queue.poll();
            count++;

            for(int i=0; i<4; i++) {
                int newX = prev[0] + dx[i];
                int newY = prev[1] + dy[i];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
                    if (matrix[newX][newY] == 1 && !visited[newX][newY]) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        return count;
    }
}
