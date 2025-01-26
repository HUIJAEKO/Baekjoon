import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();

        ArrayList<int[]> arr = new ArrayList<>();

        for(int i=0; i<N; i++){
            int nation = input.nextInt();
            int goldN = input.nextInt();
            int silverN = input.nextInt();
            int bronzeN = input.nextInt();
            arr.add(new int[]{nation, goldN, silverN, bronzeN});
        }

        Collections.sort(arr, (o1, o2) -> {
            if(o1[1] != o2[1]){
                return o2[1] - o1[1];
            }else if(o1[2] != o2[2]) {
                return o2[2] - o1[2];
            }else{
                return o2[3] - o1[3];
            }
        });

        int rank = 1;
        for(int i=0; i<arr.size(); i++){
            if(i>0 && !isSame(arr.get(i), arr.get(i+1))){
                rank++;
            }

            if(arr.get(i)[0] == K) {
                System.out.println(rank);
                break;
            }
        }
    }

    static boolean isSame(int[] a, int[] b){
        return a[1] == b[1] && a[2] == b[2] && a[3] == b[3];
    }
}
