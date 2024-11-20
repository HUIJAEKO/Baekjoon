import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int INF = Integer.MAX_VALUE;

        int[][] dist = new int[V+1][V+1];
        for(int i=0; i<=V; i++){
            Arrays.fill(dist[i], INF);
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int add = Integer.parseInt(st.nextToken());
            dist[start][end] = add;
        }

        for(int middle=1; middle<=V; middle++){
            for(int start=1; start<=V; start++){
                for(int end=1; end<=V; end++){
                    if(dist[start][middle] != INF && dist[middle][end] != INF &&
                            dist[start][end] > dist[start][middle] + dist[middle][end]){
                        dist[start][end] = dist[start][middle] + dist[middle][end];
                    }
                }
            }
        }

        //싸이클
        int result = INF;
        for(int i=1; i<=V; i++){
            if(dist[i][i] < result){
                result = dist[i][i];
            }
        }

        if(result == INF){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
}
