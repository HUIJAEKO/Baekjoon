import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                answer[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : answer){
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
