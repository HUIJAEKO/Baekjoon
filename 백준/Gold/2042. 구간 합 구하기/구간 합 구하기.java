import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[4 * N];
        build(1, 1, N);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int index = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());

                long diff = value - arr[index];
                arr[index] = value;

                update(1, 1, N, index, diff);
            }

            else if (type == 2) {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                long result = query(1, 1, N, left, right);
                sb.append(result).append("\n");
            }
        }

        System.out.print(sb);
    }

    static long build(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        long left = build(node * 2, start, mid);
        long right = build(node * 2 + 1, mid + 1, end);

        return tree[node] = left + right;
    }

    static void update(int node, int start, int end, int index, long diff) {
        if (index < start || index > end) {
            return;
        }

        tree[node] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, index, diff);
            update(node * 2 + 1, mid + 1, end, index, diff);
        }
    }

    static long query(int node, int start, int end, int left, int right) {

        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right)
                + query(node * 2 + 1, mid + 1, end, left, right);
    }
}
