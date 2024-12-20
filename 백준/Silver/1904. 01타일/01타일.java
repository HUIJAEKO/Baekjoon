import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        if(N == 1){
            System.out.println(1);
            return;
        }else if(N==2){
            System.out.println(2);
            return;
        }

        int[] answer = new int[N+1];
        answer[1] = 1;
        answer[2] = 2;

        for(int i=3; i<N+1; i++){
            answer[i] = (answer[i-1] + answer[i-2]) % 15746;
        }

        System.out.println(answer[N]);
    }
}
