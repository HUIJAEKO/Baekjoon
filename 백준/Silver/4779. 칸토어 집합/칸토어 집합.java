import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextInt()) {
            int n = input.nextInt();
            int length = (int) Math.pow(3, n);
            char[] result = new char[length];

            for (int i = 0; i < length; i++) {
                result[i] = '-';
            }
            generateCantor(result, 0, length);
            System.out.println(new String(result));
        }
    }

    static void generateCantor(char[] result, int start, int length) {
        if (length == 1) {
            return;
        }

        int segmentSize = length / 3;
        for (int i = start + segmentSize; i < start + segmentSize * 2; i++) {
            result[i] = ' ';
        }

        generateCantor(result, start, segmentSize); 
        generateCantor(result, start + segmentSize * 2, segmentSize);
    }
}
