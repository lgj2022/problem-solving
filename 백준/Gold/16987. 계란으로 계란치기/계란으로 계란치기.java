import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] hp;
    static int[] weight;
    static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        hp = new int[n];
        weight = new int[n];

        for(int i = 0; i< n; i++) {
            st = new StringTokenizer(br.readLine());
            hp[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        breakegg(0, 0);

        System.out.println(max);
    }

    static void breakegg(int idx, int cnt) {
        if (idx == n) {
            max = Math.max(max, cnt);
            return;
        }
        if (hp[idx] <= 0 || cnt == n - 1) {
            breakegg(idx + 1, cnt);
            return;
        }
        int nCnt = cnt;
        for (int i = 0; i < n; i++) {
            if (i == idx) continue;
            if (hp[i] <= 0) continue;
            hp[idx] -= weight[i];
            hp[i] -= weight[idx];
            if (hp[idx] <= 0) {
                cnt++;
            }
            if (hp[i] <= 0) {
                cnt++;
            }
            breakegg(idx + 1, cnt);
            hp[idx] += weight[i];
            hp[i] += weight[idx];
            cnt = nCnt;
        }
    }
}