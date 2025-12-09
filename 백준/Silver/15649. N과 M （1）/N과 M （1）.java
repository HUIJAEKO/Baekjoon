import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] S;
    static boolean[] V;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();
        S = new int[N];
        V = new boolean[N];

        backtracking(0);
    }

    static void backtracking(int length) {
        if (length == M) {
            printArray();
        }

        for (int i=0; i<N; i++) {
            if (!V[i]) {
                V[i] = true;
                S[length] = i;
                backtracking(length + 1);
                V[i] = false;
            }
        }
    }

    static void printArray() {
        for (int i=0; i<M; i++) {
            System.out.println(S[i] + 1 + "");
        }
    }
}
