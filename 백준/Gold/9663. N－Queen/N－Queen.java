import java.util.Scanner;

public class Main {

    static int N;
    static int[] board;
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        board = new int[N];

        countNum(0);
        System.out.println(count);
    }

    static void countNum(int row){
        if(row == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            board[row] = i;

            if(isPassed(row)){
                countNum(row+1);
            }
        }
    }

    static boolean isPassed(int row){
        for(int i=0; i<row; i++){
            if(board[row] == board[i] || row - i == Math.abs(board[row] - board[i])){
                return false;
            }
        }

        return true;
    }
}
