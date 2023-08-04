package huawei;

import java.util.*;

public class P1019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] lines = new int[n][3];
        for (int i=0; i<n; i++) {
            lines[i][0] = scanner.nextInt();
        }
        for (int i=0; i<n; i++) {
            lines[i][1] = scanner.nextInt();
        }
        for (int i=0; i<n; i++) {
            lines[i][2] = scanner.nextInt();
        }
        Arrays.sort(lines, (l1, l2) -> l1[0]-l2[0]);
        int[] dp = new int[n];
        dp[0] = lines[0][2];
        for (int i=1; i<n; i++) {
            dp[i] = lines[i][2];
            for (int j=0; j<i; j++) {
                if (lines[i][0]-lines[i][1] >= lines[j][0]+lines[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+lines[i][2]);
                }
            }
        }
        int res = dp[0];
        for (int i=1; i<n; i++) res = Math.max(res, dp[i]);
        System.out.println(res);
    }
}
// dp[i] 表示以第i条为最后一条第总价值
