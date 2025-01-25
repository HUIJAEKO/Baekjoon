import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt(); 

        for (int t = 0; t < testCases; t++) {
            int testCaseNumber = sc.nextInt(); 
            int[] students = new int[20];

            for (int i = 0; i < 20; i++) {
                students[i] = sc.nextInt();
            }

            int steps = 0; 

            for (int i = 1; i < 20; i++) {
                int key = students[i];
                int j = i - 1;

                while (j >= 0 && students[j] > key) {
                    students[j + 1] = students[j];
                    j--;
                    steps++; 
                }
                students[j + 1] = key;
            }

            System.out.println(testCaseNumber + " " + steps);
        }
    }
}
