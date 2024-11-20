import java.io.*;
import java.util.*;

public class Main {
    static Stack<Integer>[] stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stack = new Stack[4];
        for(int i=0; i<4; i++){
            stack[i] = new Stack<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int element = Integer.parseInt(st.nextToken());
            if(!isInput(element)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static boolean isInput(int element) {
        for (int j = 0; j < stack.length; j++) {
            if (stack[j].isEmpty() || stack[j].peek() < element) {
                stack[j].add(element);
                return true;
            }
        }
        return false;
    }
}
