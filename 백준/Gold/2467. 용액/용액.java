import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] nums = new int[N];

        for (int i=0; i<N; i++) {
            nums[i] = input.nextInt();
        }

        int left = 0;
        int right = N-1;

        int bestL = nums[left];
        int bestR = nums[right];
        int mindiff = Math.abs(bestL + bestR);

        while (left < right) {
            int sum = nums[left] + nums[right];
            int diff = Math.abs(sum);

            if (diff < mindiff) {
                mindiff = diff;
                bestL = nums[left];
                bestR = nums[right];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(bestL + " " + bestR);
    }
}
