import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[100001];

        int start = 0;
        int end = 0;
        Long cnt = 0L;

        while (start < N) {
            while (end < N && !visited[nums[end]]) {
                visited[nums[end]] = true;
                end++;

                cnt += (end - start);
            }

            visited[nums[start]] = false;
            start++;
        }

        System.out.println(cnt);
    }
}
