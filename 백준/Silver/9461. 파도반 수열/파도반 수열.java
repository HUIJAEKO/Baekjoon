import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int max = 0;
        int[] num = new int[T];
        for(int i=0; i<T; i++){
            num[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, num[i]);
        }

        long[] answer = new long[Math.max(max+1, 4)];
        answer[1] = 1;
        answer[2] = 1;
        answer[3] = 1;


        for(int i=4; i<=max; i++){
            answer[i] = answer[i-2] + answer[i-3];
        }


        for(int i=0; i<T; i++){
            System.out.println(answer[num[i]]);
        }
    }
}
