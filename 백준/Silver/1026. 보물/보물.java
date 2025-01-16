import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }

        Arrays.sort(A);
        Integer[] BDesc = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(BDesc, Collections.reverseOrder());

        int S = 0;
        for (int i = 0; i < n; i++) {
            S += A[i] * BDesc[i];
        }

        System.out.println(S);
    }
}