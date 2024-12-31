import java.util.Scanner;

public class Main {
    static int N;
    static boolean found = false;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        back("");
    }

    static void back(String str){
        if(found){
            return;
        }
        
        if(str.length() == N){
            System.out.println(str);
            found = true;
            return;
        }

        for(int i=1; i<=3; i++){
            if(isPassed(str+i)){
                back(str+i);
            }
        }
    }

    static boolean isPassed(String str){
        int len = str.length();

        for(int i=1; i<=len/2; i++){
            if(str.substring(len-i).equals(str.substring(len-2*i, len-i))){
                return false;
            }
        }

        return true;
    }
}
