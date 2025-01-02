import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        if(n==1){
            System.out.println(1);
            return;
        }else if(n==2){
            System.out.println(3);
            return;
        }

        int[] count = new int[n+1];
        count[1] = 1;
        count[2] = 3;
        for(int i=3; i<=n; i++){
            count[i] = (count[i-1] + 2*count[i-2]) % 10007;
        }

        System.out.println(count[n]);
    }
}

