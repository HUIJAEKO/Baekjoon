import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char[] arr;
    static int L, C;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        L = input.nextInt();
        C = input.nextInt();

        arr = new char[C];
        for (int i=0; i<C; i++) {
            arr[i] = input.next().charAt(0);
        }
        Arrays.sort(arr);

        backtracking(0,0, 0, 0);
        System.out.println(result);
    }

    static void backtracking(int index, int len, int a, int b) {
        if (len == L) {
            if (a >= 1 && b >= 2) {
                result.append(sb).append('\n');
            }
            return;
        }

        for (int i=index; i<C; i++) {
            char ch = arr[i];
            sb.append(ch);

            if(isVowel(ch)) {
                backtracking(i + 1, len + 1, a + 1, b);
            } else {
                backtracking(i + 1, len + 1, a, b + 1);
            }

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
