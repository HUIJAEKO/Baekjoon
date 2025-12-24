import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();

        int divide = 1;
        for (int i=1; i<=K; i++) {
            divide *= i;
        }

        int answer = 1;
        while (K > 0) {
            answer *= N;
            K--;
            N--;
        }

        System.out.println(answer / divide);
    }
}
