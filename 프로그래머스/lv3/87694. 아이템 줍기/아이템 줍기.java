import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // test
    public static void main(String[] args) {
        System.out.println(solution(new int[][] { { 1, 1, 3, 7 }, { 2, 2, 7, 4 }, { 4, 3, 6, 6 } }, 1, 2, 6, 6)); // 13
    }

    static class Rectangle {
        int x1;
        int y1;
        int x2;
        int y2;

        public Rectangle() {
            // TODO Auto-generated constructor stub
        }

        public Rectangle(int x1, int y1, int x2, int y2) {
            super();
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public boolean isIn(int xt, int yt) {
            if (x1 < xt && xt < x2 && y1 < yt && yt < y2) {
                return true;
            }
            return false;
        }

    }

    static int[][] map;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static List<Rectangle> rects;

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        map = new int[102][102];
        rects = new ArrayList<>();

        for (int[] rec : rectangle) {
            int xmin = rec[0] * 2;
            int ymin = rec[1] * 2;
            int xmax = rec[2] * 2;
            int ymax = rec[3] * 2;
            rects.add(new Rectangle(xmin, ymin, xmax, ymax));
            for (int x = xmin; x <= xmax; x++) {
                for (int y = ymin; y <= ymax; y++) {
                    map[x][y] -= 1;
                }
            }
        }

        int cx = characterX * 2;
        int cy = characterY * 2;
        int ix = itemX * 2;
        int iy = itemY * 2;

        Queue<int[]> q = new LinkedList<>();
        int nx = 0;
        int ny = 0;
        q.add(new int[] { cx, cy, 1 });
        while (!q.isEmpty()) {
            int[] p = q.poll();
            cx = p[0];
            cy = p[1];
            if (cx == ix && cy == iy) {
                return (p[2] - 1) / 2;
            }
            map[cx][cy] = p[2];
            for (int i = 0; i < 4; i++) {
                nx = cx + dr[i];
                ny = cy + dc[i];
                if (map[nx][ny] < 0 && !inRect(nx, ny)) {
                    q.add(new int[] { nx, ny, p[2] + 1 });
                }
            }
        }
        return -1;
    }

    private static boolean inRect(int nx, int ny) {
        for (Rectangle r : rects) {
            if (r.isIn(nx, ny)) {
                return true;
            }
        }
        return false;
    }
}