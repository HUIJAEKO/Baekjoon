import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int oddCount = 0;
        int maxEven = 0;

        for (int right = 0; right < N; right++) {
            if (arr[right] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > K) {
                if (arr[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            int evenCount = (right - left + 1) - oddCount;
            maxEven = Math.max(maxEven, evenCount);
        }

        System.out.println(maxEven);
    }
}
