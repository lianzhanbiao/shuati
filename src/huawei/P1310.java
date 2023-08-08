package huawei;

import java.util.Scanner;

public class P1310 {
    static boolean[][] matrix = new boolean[15][15];
    static int m, n;
    static int ans = (int) 1e9;

    static boolean check(int x, int y, int len) {
        // 判断从第x行第y个格子开始能否填充边长为len的正方形
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (matrix[x + i][y + j])
                    return false;
            }
        }
        return true;
    }

    static void fill(int x, int y, int len) {
        // 采用异或方法进行填充/取消填充
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                matrix[x + i][y + j] ^= true;
            }
        }
    }

    static void dfs(int x, int y, int cnt) {
        if (cnt >= ans)
            return; // 剪枝，当前记录数已经≥已记录的最小答案，不再进行搜索
        if (x == m + 1) {
            ans = cnt; // 填充完毕，更新答案
            return;
        }
        if (y > n)
            dfs(x + 1, 1, cnt);
        boolean full = true;
        for (int i = y; i <= n; ++i) { // 从当前行的第y个格子开始枚举，找到第一个没有填充的格子
            if (!matrix[x][i]) { // 当前格子未填充，尝试填充正方形
                full = false;
                for (int j = Math.min(n - i + 1, m - x + 1); j >= 1; --j) { // 枚举填充正方形的边长，从长边开始枚举
                    if (check(x, i, j)) { // 判断从第x行第i个格子开始能不能填充边长为j的正方形
                        fill(x, i, j); // 填充
                        dfs(x, y + j, cnt + 1); // 填充完一个正方形，尝试下一次填充
                        fill(x, i, j); // 取消填充
                    }
                }
                break; // 尝试在当前格子填充正方形的所有情况已经全部考虑，直接跳出循环
            }
        }
        if (full)
            dfs(x + 1, 1, cnt); // 当前行都填充了，搜索下一行
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        dfs(1, 1, 0);
        System.out.println(ans);
        scanner.close();
    }
}