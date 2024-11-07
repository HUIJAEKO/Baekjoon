import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long A = input.nextLong();
        long B = input.nextLong();

        while(B != 0){
            long temp = B;
            B = A % B;
            A = temp;
        }

        String result = "1".repeat((int)A);
        System.out.println(result);
    }
}
