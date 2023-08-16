package meituan;

import java.util.*;

public class P1078 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] times = new int[n][2];
        int[] diff = new int[100002];
        for (int i=0; i<n; i++) {
            times[i][0] = in.nextInt();
        }
        int x=0, y=0;
        for (int i=0; i<n; i++) {
            times[i][1] = in.nextInt();
            diff[times[i][0]] += 1;
            diff[times[i][1]+1] -= 1;
        }
        int count = 0;
        for (int i=0; i<100001; i++) {
            count = count + diff[i];
            if (count > x) {
                x = count;
                y = 1;
            } else if (count == x) {
                y += 1;
            }
        }
        System.out.println(x+" "+y);
    }
}
// 5 8 8 9
// 5 3 0 1
// 5 9 9 9
// 5 4 0 0