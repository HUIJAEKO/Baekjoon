import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = Integer.MAX_VALUE;

        String[] subtractions = input.nextLine().split("-");
        for(String subtraction : subtractions) {
            int temp = 0;
            String[] additions = subtraction.split("\\+");
            for(String addition : additions){
                temp += Integer.parseInt(addition);
            }

            if(sum==Integer.MAX_VALUE){
                sum = temp;
            }else{
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
