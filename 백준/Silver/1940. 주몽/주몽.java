import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);

        int result = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if(sum == M){
                result++;
                left++;
                right--;
            }else if(sum < M){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(result);
    }
}
