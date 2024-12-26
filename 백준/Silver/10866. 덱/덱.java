import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine()); 

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            if (command.startsWith("push_front")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(value);
            } else if (command.startsWith("push_back")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                deque.addLast(value);
            } else if (command.equals("pop_front")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            } else if (command.equals("pop_back")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            } else if (command.equals("back")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
