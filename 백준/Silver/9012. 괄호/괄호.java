import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.nextLine();

        for(int i=0; i<N; i++) {
            String str = input.nextLine();
            if(isTrue(str)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean isTrue(String str) {
        int n = 0;
        for (int j = 0; j < str.length(); j++) {
            char ch = str.charAt(j);
            if (ch == '(') {
                n++;
            } else if(ch == ')'){
                n--;
                if (n < 0) {
                    return false;
                }
            }
        }
        return n == 0;
    }
}
