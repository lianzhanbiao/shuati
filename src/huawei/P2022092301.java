package huawei;

import java.util.*;

public class P2022092301 {
    static int[] influence;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] f = new int[n];
        influence = new int[n];
        for (int i=0; i<n; i++) {
            f[i] = in.nextInt();
        }
        for (int i=0; i<n; i++) {
            setInfluence(i, f);
        }
        Integer[] ids = new Integer[n];
        for (int i=0; i<n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (x, y) -> {
            if (influence[x] > influence[y]) {
                return -1;
            } else if (influence[x] == influence[y]) {
                return x - y;
            } else {
                return 1;
            }
        });
        for (int id : ids) {
            System.out.print(id + " ");
        }
//        System.out.println();
//        for (int influ : influence) {
//            System.out.print(influ + " ");
//        }
    }
    public static void setInfluence(int i, int[]f) {
        if (i == -1) {
            return;
        }
        influence[i]++;
        setInfluence(f[i], f);
    }
}
