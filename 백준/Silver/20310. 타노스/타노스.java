import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        int zero = 0;
        int one = 0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                zero++;
            }else{
                one++;
            }
        }

        int removeZero = zero / 2;
        int removeOne = one / 2;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '1' && removeOne > 0) {
                removeOne--;
            } else {
                sb.append(c);
            }
        }

        StringBuilder finalResult = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '0' && removeZero > 0) {
                removeZero--;
            } else {
                finalResult.append(c);
            }
        }

        System.out.println(finalResult.reverse());
    }
}
