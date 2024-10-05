import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        double[] arr = new double[N];

        double max = 0;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        double average = (sum / max * 100.0) / N;
        System.out.println(average);
    }
}