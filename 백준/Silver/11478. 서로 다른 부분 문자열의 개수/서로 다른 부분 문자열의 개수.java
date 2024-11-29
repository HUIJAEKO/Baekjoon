import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        Scanner input = new Scanner(System.in);
        String str = input.next();

        for(int i=0; i<str.length(); i++){
            hs.add(String.valueOf(str.charAt(i)));
        }

        for(int i=1; i<str.length(); i++){
            for(int j=0; j<str.length() - i; j++){
                hs.add(str.substring(j, j+i+1));
            }
        }

        System.out.println(hs.size());
    }
}
