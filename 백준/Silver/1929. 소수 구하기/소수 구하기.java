
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        int N = input.nextInt();
        for(int i=M; i<=N; i++){
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

    }

    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        if(n==2){
            return true;
        }
        if(n%2==0) {
            return false;
        }
        for(int j=3; j<=Math.sqrt(n); j+=2){
            if(n%j==0){
                return false;
            }
        }
        return true;
    }
}
