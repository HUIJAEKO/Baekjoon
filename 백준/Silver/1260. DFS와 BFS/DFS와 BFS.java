import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int V = input.nextInt();

        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];
        for(int i=0; i<=N; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            A[a].add(b);
            A[b].add(a);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(A[i]);
        }

        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int start){
        System.out.print(start + " ");
        visited[start] = true;
        for(int next : A[start]){
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int prev = queue.poll();
            System.out.print(prev + " ");
            for(int next : A[prev]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
