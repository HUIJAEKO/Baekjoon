import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        int sum = 0;
        for(int i=0; i<N; i++){
                num[i] = Integer.parseInt(br.readLine());
                sum+=num[i];
        }

        Arrays.sort(num);

        //1
        System.out.println(Math.round((double) sum / N));

        //2
        System.out.println(num[N / 2]);

        //3
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : num){
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int max = Collections.max(map.values());

        for(int n : map.keySet()){
            if(map.get(n)  ==  max){
                arr.add(n);
            }
        }

        Collections.sort(arr);
        if(arr.size() == 1){
            System.out.println(arr.get(0));
        }else{
            System.out.println(arr.get(1));
        }


        //4
        System.out.println(num[N-1] - num[0]);
    }
}
