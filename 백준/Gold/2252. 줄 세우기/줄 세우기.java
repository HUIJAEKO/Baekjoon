import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i=0; i<=n; i++){
            A.add(new ArrayList<>());
        }

        int[] arr = new int[n+1];
        for(int i=0; i<m; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            A.get(a).add(b);
            arr[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(arr[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for(int next : A.get(now)){
                arr[next]--;
                if(arr[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }
}
