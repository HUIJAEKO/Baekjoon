import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int target = clockNumber(a, b, c, d);

        boolean[] isClock = new boolean[10000];

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        int cn = clockNumber(i, j, k, l);
                        isClock[cn] = true;
                    }
                }
            }
        }

        ArrayList<Integer> clocks = new ArrayList<>();
        for (int x = 1111; x <= 9999; x++) {
            if (isClock[x]) clocks.add(x);
        }
        Collections.sort(clocks);

        int idx = Collections.binarySearch(clocks, target);
        System.out.println(idx + 1);
    }
    
    static int clockNumber(int a, int b, int c, int d) {
        int r0 = a * 1000 + b * 100 + c * 10 + d;
        int r1 = b * 1000 + c * 100 + d * 10 + a;
        int r2 = c * 1000 + d * 100 + a * 10 + b;
        int r3 = d * 1000 + a * 100 + b * 10 + c;
        return Math.min(Math.min(r0, r1), Math.min(r2, r3));
    }
}