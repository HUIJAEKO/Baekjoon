import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            if (value < x) {
                System.out.print(value + " "); 
            }
        }
    }
}
