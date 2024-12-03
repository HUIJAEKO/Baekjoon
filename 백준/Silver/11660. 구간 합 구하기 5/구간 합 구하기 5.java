import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n+1][n+1];
        for(int y=1; y<=n; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=1; x<=n; x++){
                matrix[y][x] = matrix[y][x-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int j=y1; j<=y2; j++){
                if(x1 == 1){
                    sum += matrix[j][x2];
                }else{
                    sum += (matrix[j][x2] - matrix[j][x1-1]);
                }
            }
            System.out.println(sum);
        }
    }
}
