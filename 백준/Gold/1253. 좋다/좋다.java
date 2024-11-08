
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        long[] arr = new long[N];
        for(int i=0; i<N; i++) {
            arr[i] = input.nextLong();
        }

        Arrays.sort(arr);
        int answer = 0;

        for (int i = 0; i < N; i++) {
            long num = arr[i];
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == i) {
                    left++;  // arr[i]는 제외
                } else if (right == i) {
                    right--;  // arr[i]는 제외
                } else {
                    long sum = arr[left] + arr[right];

                    if (sum == num) {
                        answer++;
                        break;  // 합이 일치하면 더 이상 찾을 필요 없음
                    } else if (sum < num) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
