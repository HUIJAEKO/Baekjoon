import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        int[] balloons = new int[N];
        boolean[] popped = new boolean[N]; // 터진 풍선 표시
        for (int i = 0; i < N; i++) {
            balloons[i] = input.nextInt();
        }

        StringBuilder result = new StringBuilder();
        int currentIndex = 0;

        for (int i = 0; i < N; i++) {
            result.append((currentIndex + 1)).append(" ");
            int move = balloons[currentIndex];
            popped[currentIndex] = true;

            if (i == N - 1) break; // 마지막 풍선이면 종료

            // 다음 인덱스 찾기
            if (move > 0) {
                for (int count = 0; count < move; ) {
                    currentIndex = (currentIndex + 1) % N;
                    if (!popped[currentIndex]) count++;
                }
            } else {
                for (int count = 0; count < -move; ) {
                    currentIndex = (currentIndex - 1 + N) % N;
                    if (!popped[currentIndex]) count++;
                }
            }
        }

        System.out.println(result.toString().trim());
    }
}
