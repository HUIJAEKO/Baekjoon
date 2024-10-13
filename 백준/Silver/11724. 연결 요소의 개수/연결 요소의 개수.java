import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int N, M;
    static List<List<Integer>> list; // ArrayList로 변경
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();

        visited = new boolean[N + 1];
        list = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>()); // 각 노드에 대해 ArrayList 초기화
        }

        for (int i = 1; i <= M; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            list.get(u).add(v); // 인접 리스트에 간선 추가
            list.get(v).add(u); // 무향 그래프이므로 양방향 추가
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfsStack(i);
                count++;
            }
        }

        System.out.println(count);
    }

    // 스택을 사용한 DFS
    static void dfsStack(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        visited[n] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            // 현재 노드의 이웃 노드 탐색
            for (int i = 0; i < list.get(current).size(); i++) {
                int neighbor = list.get(current).get(i);
                if (!visited[neighbor]) {
                    stack.push(neighbor); // 이웃 노드를 스택에 추가
                    visited[neighbor] = true; // 이웃 노드를 방문 처리
                }
            }
        }
    }
}
