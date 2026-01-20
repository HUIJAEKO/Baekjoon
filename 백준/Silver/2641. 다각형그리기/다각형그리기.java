import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] base = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            base[i] = Integer.parseInt(st.nextToken());
        }    

        int M = Integer.parseInt(br.readLine());
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int[] arr = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }    

            if (isSame(base, arr)) {
                result.add(arr);
            }
        }

        System.out.println(result.size());
        for (int[] r : result) {
            for (int x : r) {
                System.out.print(x + " ");
            }    
            System.out.println();
        }
    }
    
    static boolean isSame(int[] base, int[] target) {
        String baseStr = toString(base);
        String doubled = baseStr + baseStr;

        if (doubled.contains(toString(target))) {
            return true;
        }    

        int[] rev = new int[N];
        for (int i = 0; i < N; i++) {
            rev[i] = reverseDir(target[N - 1 - i]);
        }
        if (doubled.contains(toString(rev))) {
            return true;
        }    

        return false;
    }
    
    static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(x);
        }
        return sb.toString();
    }

    static int reverseDir(int d) {
        if (d == 1) return 3;
        if (d == 2) return 4;
        if (d == 3) return 1;
        return 2;
    }
}
