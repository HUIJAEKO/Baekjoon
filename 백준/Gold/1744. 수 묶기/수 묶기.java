import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < N; i++) {
            int x = input.nextInt();

            if (x > 1) {
                pos.add(x);
            } else if (x == 1) {
                ones++;
            } else if (x == 0) {
                zeros++;
            } else {
                neg.add(x);
            }
        }

        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg);

        int answer = 0;

        for (int i = 0; i < pos.size(); i += 2) {
            if (i + 1 < pos.size()) {
                answer += pos.get(i) * pos.get(i + 1);
            } else {
                answer += pos.get(i);
            }
        }

        answer += ones;

        for (int i = 0; i < neg.size(); i += 2) {
            if (i + 1 < neg.size()) {
                answer += neg.get(i) * neg.get(i + 1);
            } else {
                if (zeros == 0) {
                    answer += neg.get(i);
                }
            }
        }

        System.out.println(answer);
    }
}
