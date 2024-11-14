import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] distance;
    static int V;
    static int E;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        V = input.nextInt();
        E = input.nextInt();
        int startPoint = input.nextInt();

        visited = new boolean[V+1];
        distance = new int[V+1];
        for(int i=1; i<=V; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[startPoint] = 0;

        A = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            int add = input.nextInt();
            A[start].add(new Node(end, add));
        }

        findShort();

       for(int i=1; i<=V; i++){
           if(distance[i] == Integer.MAX_VALUE){
               System.out.println("INF");
           }else{
               System.out.println(distance[i]);
           }
       }
    }
    public static void findShort() {
        for(int i=1; i<=V; i++){
            int startPoint = findMin();
            visited[startPoint] = true;
            for(Node node : A[startPoint]){
                if(distance[startPoint] + node.add < distance[node.end]){
                    distance[node.end] = distance[startPoint] + node.add;
                }
            }
        }
    }

    public static int findMin(){
        int min = Integer.MAX_VALUE;
        int startPoint = 0;
        for(int i=1; i<=V; i++){
            if(distance[i] < min && !visited[i]){
                min = distance[i];
                startPoint = i;
            }
        }
        return startPoint;
    }
}

class Node {
        int end;
        int add;

    public Node(int end, int add) {
        this.end = end;
        this.add = add;
    }
}


// 1 - 2,2 3,3
// 2 - 3,4 4,5
// 3 - 4,6
// 4 -
// 5 - 1,1