import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean[] bir;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int V = input.nextInt();
        int E = input.nextInt();

        A = new ArrayList[V+1];
        visited = new boolean[V+1];
        bir = new boolean[V+1];

        for(int i=0; i<=V; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=1; i<=E; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            A[a].add(b);
            A[b].add(a);
        }

        dfs(1);
        int count = -1;
        for(int i=1; i<=V; i++){
            if(bir[i]){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int start){
        visited[start] = true;
        bir[start] = true;
        for(int next : A[start]){
            if(!visited[next]){
                visited[next] = true;
                bir[next] = true;
                dfs(next);
            }
        }
    }
}
