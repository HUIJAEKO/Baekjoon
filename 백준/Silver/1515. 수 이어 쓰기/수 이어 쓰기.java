import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int idx = 0; 
        int n = 0;   

        while (idx < s.length()) {   
            n++;                     
            String cur = String.valueOf(n); 

            for (int j = 0; j < cur.length() && idx < s.length(); j++) {
                if (cur.charAt(j) == s.charAt(idx)) {
                    idx++;
                }
            }
        }

        System.out.println(n);
    }
}