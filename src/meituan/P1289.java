package meituan;

import java.util.*;

public class P1289 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i=0; i<T; i++) {
            int n = in.nextInt();
            int[] l = new int[n-1];
            for (int j=0; j<n-1; j++) {
                l[j] = in.nextInt();
            }
            int m = in.nextInt();
            int[] r = new int[n-1];
            for (int j=0; j<m-1; j++) {
                r[j] = in.nextInt();
            }
            System.out.println(f(n, l, m, r));
        }
    }
    static String f(int n, int[] l, int m, int[] r) {

        return "";
    }
}
