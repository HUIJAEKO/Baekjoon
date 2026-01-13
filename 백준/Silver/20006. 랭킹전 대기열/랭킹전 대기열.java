import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Player {
        int level;
        String name;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    static class Room {
        int base;
        List<Player> players = new ArrayList<>();

        Room(int base) {
            this.base = base;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            Player player = new Player(level, name);
            boolean entered = false;

            for (Room room : rooms) {
                if (room.players.size() < m &&
                        Math.abs(room.base - level) <= 10) {

                    room.players.add(player);
                    entered = true;
                    break;
                }
            }

            if (!entered) {
                Room room = new Room(level);
                room.players.add(player);
                rooms.add(room);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Room room : rooms) {
            if (room.players.size() == m) {
                sb.append("Started!\n");
            }
            else {
                sb.append("Waiting!\n");
            }

            room.players.sort(Comparator.comparing(p1 -> p1.name));

            for (Player pl : room.players) {
                sb.append(pl.level).append(" ").append(pl.name).append("\n");
            }
        }

        System.out.print(sb);
    }
}
