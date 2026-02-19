import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, N;
    static char[][] grid;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        if (N == 1) { 
            print(grid);
            return;
        }

        if (N % 2 == 0) {
            print(fullBomb());
            return;
        }

        char[][] once = explode(grid);
        if (N % 4 == 3) {
            print(once);
        } else { 
            char[][] twice = explode(once);
            print(twice);
        }
    }

    static char[][] explode(char[][] cur) {
        char[][] next = fullBomb();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (cur[i][j] == 'O') {
                    next[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dr[k];
                        int nj = j + dc[k];
                        if (0 <= ni && ni < R && 0 <= nj && nj < C) {
                            next[ni][nj] = '.';
                        }
                    }
                }
            }
        }

        return next;
    }

    static char[][] fullBomb() {
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = 'O';
            }
        }
        return grid;
    }

    static void print(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(grid[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
