import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = input.nextLine();
        char[] chars = str.toCharArray();

        Arrays.sort(chars);
        for (int i = chars.length-1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}