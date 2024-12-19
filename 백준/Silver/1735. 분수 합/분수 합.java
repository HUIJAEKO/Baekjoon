import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int e = a * d + b * c;
        int f = b * d;

        for(int i=c/2; i>=2; i--){
            if(e % i == 0 && f % i == 0){
                e /= i;
                f /= i;
            }
        }
        System.out.println(e + " " + f);
    }
}
