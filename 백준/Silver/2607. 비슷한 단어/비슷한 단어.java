import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String base = br.readLine();
        int[] baseCnt = new int[26];

        for (char c : base.toCharArray()) {
            baseCnt[c - 'A']++;
        }

        int answer = 0;

        for (int i = 0; i < N - 1; i++) {
            String word = br.readLine();
            int[] cnt = new int[26];

            for (char c : word.toCharArray()) {
                cnt[c - 'A']++;
            }

            int diff = 0;
            for (int j = 0; j < 26; j++) {
                diff += Math.abs(baseCnt[j] - cnt[j]);
            }

            int lenDiff = Math.abs(base.length() - word.length());

            if (diff == 0 || diff == 1 || (diff == 2 && lenDiff == 0)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
