import java.io.*;
import java.util.HashMap;

public class Main {
    static class Node{
        char data;
        Node left, right;

        Node(char data){
            this.data = data;
            left = right = null;
        }
    }

    static HashMap<Character, Node> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            char parent = str[0].charAt(0);
            char left = str[1].charAt(0);
            char right = str[2].charAt(0);

            tree.putIfAbsent(parent, new Node(parent));
            Node parentNode = tree.get(parent);

            if(left != '.'){
                tree.putIfAbsent(left, new Node(left));
                parentNode.left = tree.get(left);
            }

            if(right != '.'){
                tree.putIfAbsent(right, new Node(right));
                parentNode.right = tree.get(right);
            }
        }

        Node start = tree.get('A');
        preOrder(start);
        System.out.println();
        inOrder(start);
        System.out.println();
        postOrder(start);
    }

    public static void preOrder(Node start){
        if(start == null){
            return;
        }
        System.out.print(start.data);
        preOrder(start.left);
        preOrder(start.right);
    }

    public static void inOrder(Node start){
        if(start == null){
            return;
        }
        inOrder(start.left);
        System.out.print(start.data);
        inOrder(start.right);
    }

    public static void postOrder(Node start){
        if(start == null){
            return;
        }
        postOrder(start.left);
        postOrder(start.right);
        System.out.print(start.data);
    }
}


