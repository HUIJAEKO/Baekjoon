import java.util.Scanner;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            int question = input.nextInt();
            int a = input.nextInt();
            int b = input.nextInt();

            if(question == 1){
                a = find(a);
                b = find(b);
                if(check(a,b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }else{
                union(a,b);
            }
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }

    public static boolean check(int a, int b){
        return a==b;
    }
}
