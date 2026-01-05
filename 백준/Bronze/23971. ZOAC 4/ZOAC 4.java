import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int H = input.nextInt();
        int W = input.nextInt();
        int N = input.nextInt();
        int M = input.nextInt();

        int height = 0;
        for (int i=1; i<=H; i+=(N+1)) {
            height++;
        }

        int width = 0;
        for (int i=1; i<=W; i+=(M+1)) {
            width++;
        }

        System.out.println(height * width);
    }
}
