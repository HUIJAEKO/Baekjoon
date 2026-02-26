import java.util.*;

class Solution {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 'X') {
                    sums.add(bfs(i, j));
                }
            }
        }

        if (sums.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(sums);
        int[] answer = new int[sums.size()];
        for (int i = 0; i < sums.size(); i++) {
            answer[i] = sums.get(i);
        }
        
        return answer;
    }

    static int bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        int sum = map[sx][sy] - '0';

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'X') continue;

                visited[nx][ny] = true;
                sum += (map[nx][ny] - '0');
                q.add(new int[]{nx, ny});
            }
        }

        return sum;
    }
}