import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        boolean pal = true;
        for(int i=0; i<str.length() / 2; i++){
            if(str.charAt(str.length() - 1 - i) != str.charAt(i)){
                pal = false;
                break;
            }
        }

        System.out.println(pal ? 1 : 0);
    }
}
