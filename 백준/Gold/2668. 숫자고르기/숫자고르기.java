import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visited, finished;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int x : result) {
            System.out.println(x);
        }
    }

    static void dfs(int cur) {
        visited[cur] = true;
        int next = arr[cur];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            int temp = next;
            result.add(temp);
            while (temp != cur) {
                temp = arr[temp];
                result.add(temp);
            }
        }

        finished[cur] = true;
    }
}
