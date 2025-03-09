import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        char[] arr = input.next().toCharArray();

        boolean[] eaten = new boolean[N];
        int count = 0;

        for(int i=0; i<N; i++){
            if(arr[i] == 'P'){
                for(int j=Math.max(0, i-K); j<=Math.min(N-1, i+K); j++){
                    if(arr[j] == 'H' && !eaten[j]){
                        eaten[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
