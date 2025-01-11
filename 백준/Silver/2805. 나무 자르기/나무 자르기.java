import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] trees = new long[N];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }

        long start = 0;
        long end = max;
        long answer = 0;

        while(start <= end){
            long mid = (start+end) / 2;
            long total = count(trees, mid);

            if(total >= M){
                answer = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        System.out.println(answer);
    }

    static long count(long[] trees, long height){
        long total = 0;
        for(long tree : trees){
            if(tree - height > 0){
                total += (tree-height);
            }
        }
        return total;
    }
}
