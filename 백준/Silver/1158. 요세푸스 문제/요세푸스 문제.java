import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            deque.addFirst(i);
        }

        System.out.print("<");
        while(!deque.isEmpty()){
            for(int i=1; i<K; i++){
                deque.addFirst(deque.removeLast());
            }
            if(deque.size() == 1){
                System.out.println(deque.removeLast() + ">");
            }else{
                System.out.print(deque.removeLast() + ", ");
            }
        }
    }
}
