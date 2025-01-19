import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];
        for(int i=0; i<N; i++){
            strs[i] = br.readLine();
        }

        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(String str : strs) {
            String[] words = str.split(" ");
            boolean passed = false;

            for (int i = 0; i < words.length; i++) {
                char first = Character.toUpperCase(words[i].charAt(0));
                if (!set.contains(first)) {
                    set.add(first);
                    words[i] = "[" + words[i].charAt(0) + "]" + words[i].substring(1);
                    passed = true;
                    break;
                }
            }

            if (!passed) {
                for (int i = 0; i < str.length(); i++) {
                    char c = Character.toUpperCase(str.charAt(i));
                    if (c != ' ' && !set.contains(c)) {
                        set.add(c);
                        str = str.substring(0, i) + "[" + str.charAt(i) + "]" + str.substring(i + 1);
                        break;
                    }
                }
                sb.append(str).append("\n");
            } else {
                sb.append(String.join(" ", words)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
