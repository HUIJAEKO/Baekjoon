import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String dna = br.readLine().trim();

        st = new StringTokenizer(br.readLine());
        int[] need = new int[4];
        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[4];

        for (int i=0; i<P; i++) {
            cnt[idx(dna.charAt(i))]++;
        }

        int answer = ok(cnt, need) ? 1 : 0;

        for (int i=P; i<S; i++) {
            char outC = dna.charAt(i-P);
            char inC = dna.charAt(i);
            cnt[idx(outC)]--;
            cnt[idx(inC)]++;
            if(ok(cnt, need)) answer++;
        }

        System.out.println(answer);
    }

    static int idx(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3;
    }

    static boolean ok(int[] cnt, int[] need) {
        return cnt[0] >= need[0] &&
               cnt[1] >= need[1] &&
               cnt[2] >= need[2] &&
               cnt[3] >= need[3];
    }
}
