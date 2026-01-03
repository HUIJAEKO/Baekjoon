import java.io.*;
import java.util.*;
import java.util.Locale;

public class Main {

    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static double cross(double x1, double y1, double x2, double y2) {
        return x1 * y2 - y1 * x2;
    }

    static boolean isZero(double v) {
        return Math.abs(v) < 1e-9;
    }

    static String fmt(double v) {
        return String.format(Locale.US, "%.2f", v);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double x3 = Double.parseDouble(st.nextToken());
            double y3 = Double.parseDouble(st.nextToken());
            double x4 = Double.parseDouble(st.nextToken());
            double y4 = Double.parseDouble(st.nextToken());

            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            Point p3 = new Point(x3, y3);
            Point p4 = new Point(x4, y4);

            double vx1 = p2.x - p1.x;
            double vy1 = p2.y - p1.y;
            double vx2 = p4.x - p3.x;
            double vy2 = p4.y - p3.y;

            double det = cross(vx1, vy1, vx2, vy2);

            if (isZero(det)) {
                double rx = p3.x - p1.x;
                double ry = p3.y - p1.y;
                double c = cross(vx1, vy1, rx, ry);

                if (isZero(c)) {
                    out.append("LINE\n");
                } else {
                    out.append("NONE\n");
                }
            } else {
                double rx = p3.x - p1.x;
                double ry = p3.y - p1.y;

                double t = cross(rx, ry, vx2, vy2) / det;

                double ix = p1.x + vx1 * t;
                double iy = p1.y + vy1 * t;

                out.append("POINT ")
                   .append(fmt(ix)).append(" ")
                   .append(fmt(iy)).append("\n");
            }
        }

        System.out.print(out);
    }
}
