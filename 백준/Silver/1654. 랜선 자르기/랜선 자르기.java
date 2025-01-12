import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] lans = new long[K];
        long max = 0;
        for(int i=0; i<K; i++){
            lans[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lans[i]);
        }

        long start = 1;
        long end = max;

        while(start<=end){
            long mid = (start+end) / 2;

            if(count(mid, lans) >= N){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(end);
    }

    static long count(long mid, long[] lans){
        long total = 0;
        for(long lan : lans){
            total += (lan/mid);
        }

        return total;
    }
}
