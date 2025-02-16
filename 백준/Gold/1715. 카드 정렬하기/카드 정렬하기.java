import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> nums = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }

        int total = 0;
        while(nums.size() >= 2){
            int first = nums.poll();
            int second = nums.poll();
            int sum = first + second;
            total += sum;
            nums.add(sum);
        }

        System.out.println(total);
    }
}
