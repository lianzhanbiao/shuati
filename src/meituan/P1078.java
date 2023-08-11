package meituan;

import java.util.*;

public class P1078 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] times = new int[n][2];
        int[] mark = new int[100002];
        for (int i=0; i<n; i++) {
            times[i][0] = in.nextInt();
        }
        for (int i=0; i<n; i++) {
            times[i][1] = in.nextInt();
            for (int j=times[i][0]; j<=times[i][1]; j++) {
                mark[j] = 1;
            }
        }
    }
}
