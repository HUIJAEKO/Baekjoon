import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = input.nextInt();
        }
        int m = input.nextInt();
        Arrays.sort(arr);

        for(int i=0; i<m; i++) {
            int num = input.nextInt();
            if(binarySearch(arr, num)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    static boolean binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == num) {
                return true;
            }else if(arr[mid] < num) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
