import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static boolean[] b;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        b = new boolean[N+1];

        Eratos();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2; i<=N; i++){
            if(!b[i]){
                arr.add(i);
            }
        }

        int result = twoPointer(arr);
        System.out.println(result);


    }

    static void Eratos(){
        b[0] = true;
        b[1] = true;

        for(int i=2; i<=Math.sqrt(N); i++){
            if(!b[i]){
                for(int j=i*i; j<=N; j+=i){
                    b[j] = true;
                }
            }
        }
    }

    static int twoPointer(ArrayList<Integer> arr){
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while(right < arr.size() || sum >= N){
            if(sum < N){
                sum += arr.get(right);
                right++;
            }else if(sum > N){
                sum -= arr.get(left);
                left++;
            }else{
                count++;
                sum -= arr.get(left);
                left++;
            }
        }

        return count;
    }
}
