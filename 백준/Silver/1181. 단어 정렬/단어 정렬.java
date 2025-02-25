import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>((o1, o2) -> {
            int len = o1.length() - o2.length();
            return (len != 0) ? len : o1.compareTo(o2);
        });

        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        for(String str : set){
            System.out.println(str);
        }
    }
}
