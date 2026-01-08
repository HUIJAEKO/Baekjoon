import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] title = new String[N];
        int[] power = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int val = Integer.parseInt(br.readLine());
            sb.append(binarySearch(power, title, val)).append('\n');
        }

        System.out.print(sb);
    }

    static String binarySearch(int[] power, String[] title, int val) {
        int left = 0;
        int right = power.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (power[mid] >= val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return title[left];
    }
}
