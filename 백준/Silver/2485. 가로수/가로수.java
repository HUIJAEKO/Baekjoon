import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] num = new int[N];

        for(int i=0; i<N; i++){
            num[i] = input.nextInt();
        }

        Arrays.sort(num);

        int[] dif = new int[N-1];
        for(int i=0; i<N-1; i++){
            dif[i] = num[i+1] - num[i];
        }

        int gcdValue = dif[0];
        for (int i = 1; i < dif.length; i++) {
            gcdValue = gcd(gcdValue, dif[i]);
        }

        int count = 0;
        for (int i = 0; i < dif.length; i++) {
            count += (dif[i] / gcdValue) - 1;
        }

        System.out.println(count);
    }

    static int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
