import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        StringBuffer sb = new StringBuffer(n);
        Stack<Integer> stack = new Stack<>();
        
        int num = 1;
        for (int i = 0; i < n; i++) {
            int target = input.nextInt();

            while (num <= target) {
                stack.push(num++);
                sb.append("+\n");
            }

            if(!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            }else{
                sb.delete(0, sb.length());
                sb.append("NO\n");
                break;
            }
        }
        System.out.println(sb);
    }
}
