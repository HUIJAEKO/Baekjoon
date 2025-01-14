import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] budgets = new int[N];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            budgets[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budgets[i]);
        }
        long M = Long.parseLong(br.readLine());

        int start = 1;
        int end = max;
        long total;

        while(start <= end){
            total = 0;
            int mid = (start+end) / 2;

            for(int budget : budgets){
                if(budget > mid){
                    total += mid;
                }else{
                    total += budget;
                }
            }

            if(total > M){
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }

        System.out.println(end);
    }
}
