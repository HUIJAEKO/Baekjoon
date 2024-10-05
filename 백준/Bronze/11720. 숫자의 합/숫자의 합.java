import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        int N = input.nextInt();
        String num = input.next();

        int sum = 0;
        for(int i=0; i<N; i++) {
            //0~9 -> 48~57
            sum += num.charAt(i)-'0';
        }

        System.out.println(sum);
    }
}