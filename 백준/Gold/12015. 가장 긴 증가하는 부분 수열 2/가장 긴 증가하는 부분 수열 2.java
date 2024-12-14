import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());

        int[] num = new int[A];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int n : num){
            if(arr.isEmpty() || arr.get(arr.size()-1) < n){
                arr.add(n);
            }else{
                int index = Collections.binarySearch(arr, n);
                if(index < 0){
                    index = -(index+1);
                }
                arr.set(index, n);
            }
        }

        System.out.println(arr.size());
    }
}
