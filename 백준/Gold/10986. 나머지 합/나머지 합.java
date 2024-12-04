import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] nums = new long[N];
        for(int i=0; i<N; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long[] remainderCount = new long[M];
        remainderCount[0]++;
        long result = 0;

        for(int i=0; i<N; i++){
            sum += nums[i];
            long remainder = sum % M;

            if (remainder < 0) {
                remainder += M;
            }

            result += remainderCount[(int) remainder];
            remainderCount[(int)remainder]++;
        }

        System.out.println(result);
    }
}

