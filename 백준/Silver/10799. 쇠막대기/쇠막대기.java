import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (s.charAt(i - 1) == '(') {
                    count += stack.size();
                } else {
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }
}
