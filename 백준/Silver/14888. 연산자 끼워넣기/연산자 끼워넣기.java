import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] ops = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0]); 

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int value) {
        if (idx == N) { 
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) { 
                ops[i]--;

                if (i == 0) dfs(idx + 1, value + nums[idx]);
                else if (i == 1) dfs(idx + 1, value - nums[idx]);
                else if (i == 2) dfs(idx + 1, value * nums[idx]);
                else {
                    dfs(idx + 1, divide(value, nums[idx]));
                }

                ops[i]++; 
            }
        }
    }

    static int divide(int a, int b) {
        if (a < 0) {
            return - (Math.abs(a) / b);
        }    
        return a / b;
    }
}
