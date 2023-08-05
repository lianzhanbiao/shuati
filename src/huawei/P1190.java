package huawei;

import java.util.*;

public class P1190 {

    static int[][] m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        m = new int[10002][3];
        for (int i=0; i<=10000; i++) {
            m[i][1] = -2;
            m[i][2] = -2;
        }
        int[] ids = new int[n];
        for (int i=0; i<n; i++) {
            int id = in.nextInt();
            ids[i] = id;
            int pid = in.nextInt();
            int v = in.nextInt();
            m[id][0] = v;
            if (pid != -1) {
                if (m[pid][1] == -2) m[pid][1] = id;
                else m[pid][2] = id;
            }
        }
        boolean[] mark = new boolean[10002];
        int res = Integer.MIN_VALUE/2;
        for (int i=0; i<n; i++) {
            mark[ids[i]] = true;
            res = Math.max(res, dfs(ids[i], mark));
            mark[ids[i]] = false;
        }
        System.out.println(res);
    }
    public static int dfs (int start, boolean[] mark) {
        int res = m[start][0];
        int next1 = m[start][1];
        int next2 = m[start][2];
        int resl = 0;
        int resr = 0;
        if (next1 != -2 && !mark[next1]) {
            mark[next1] = true;
            resl = dfs(next1, mark);
            mark[next1] = false;
        }
        if (next2 != -2 && !mark[next2]) {
            mark[next2] = true;
            resr += dfs(next2, mark);
            mark[next2] = false;
        }
        return Math.max(res, Math.max(res+resl, res+resr));
    }
}
