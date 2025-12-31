import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        if (N > 1022) {
            System.out.println(-1);
            return;
        }

        for (int i=0; i<10; i++) {
            bfs(i);
        }

        Collections.sort(list);
        System.out.println(list.get(N));
    }

    static void bfs(long num) {
        list.add(num);
        long last = num % 10;

        for (long i=0; i<last; i++) {
            bfs(num * 10 + i);
        }
    }
}
