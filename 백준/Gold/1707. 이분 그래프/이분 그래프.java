import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static boolean isEven;
    static ArrayList<Integer>[] A;
    static int[] check;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int K = input.nextInt();

        for(int i=0; i<K; i++){
            int V = input.nextInt();
            int E = input.nextInt();
            A = new ArrayList[V+1];
            visited = new boolean[V+1];
            isEven = true;
            check = new int[V+1];
            //노드 개수만큼 ArrayList생성
            for(int j=1; j<=V; j++){
                A[j] = new ArrayList<Integer>();
            }

            //엣지 데이터 저장
            for(int j=0; j<E; j++){
                int start = input.nextInt();
                int end = input.nextInt();
                A[start].add(end);
                A[end].add(start);
            }

            //모든 노드에서 dfs실행
            for(int j=1; j<=V; j++){
                if(isEven){
                    dfs(j);
                }else{
                    break;
                }
            }

            if(isEven){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static void dfs(int start){
        visited[start] = true;
        for(int i : A[start]){
            if(!visited[i]){
                //직전 노드와 다른 집합으로 분류
                check[i] = (check[start] + 1) % 2;
                dfs(i);
            }else if(check[start]==check[i]){
                isEven = false;
            }
        }
    }
}
