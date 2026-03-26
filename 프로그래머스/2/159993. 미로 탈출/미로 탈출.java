import java.util.*;

class Solution {
    static int n, m;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        // map 저장 및 출발, 도착, 레버 지점 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);

                if (map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (map[i][j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (map[i][j] == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }

        // from 출발지 to 레버
        int toLever = bfs(start[0], start[1], 'L');
        if (toLever == -1) {
            return -1;
        }

        // from 레버 to 도착지
        int toExit = bfs(lever[0], lever[1], 'E');
        if (toExit == -1) {
            return -1;
        }

        return toLever + toExit;
    }

    // 거리 계산 bfs
    static int bfs(int x, int y, char target) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if (map[cx][cy] == target) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == 'X') {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return -1;
    }
}