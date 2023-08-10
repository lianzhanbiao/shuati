package huawei;

import java.util.*;


public class P1249 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String[] strs = scan.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0, c = 0; i < strs.length && c < n; i++) {
            char[] bs = Integer.toBinaryString(Integer.parseUnsignedInt(strs[i]
                            .substring(2), 16))
                    .toCharArray();
            for (int j = 0; j < 16 - bs.length && c < n; j++) arr[c++] = 0;
            for (int j = 0; j < bs.length && c < n; j++) arr[c++] = bs[j] - '0';
        }
        int ans, ans1 = -1, ans2 = -1;
        for (int i = 0; i < n; i++) {
            if (check(arr, i, 0)) {
                ans1 = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (check(arr, i, 1)) {
                ans2 = i;
                break;
            }
        }
        ans = (ans1 == -1 ? 0 : 1) + (ans2 == -1 ? 0 : 1);
        System.out.println(ans);
        if (ans1 != -1) {
            System.out.println("+" + ans1);
            int[] as = new int[n];
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) as[i - ans1] = 1;
            }
            for (int a : as) System.out.print(a);
            System.out.println();
        }
        if (ans2 != -1) {
            System.out.println("-" + ans2);
            int[] as = new int[n];
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) as[i + ans2] = 1;
            }
            for (int a : as) System.out.print(a);
        }
    }

    public static boolean check(int[] arr, int cnt, int dir) {
        int ans = 0, n = arr.length;
        if (dir == 0) { // right
            for (int i = 0, j; i < n; i++) {
                if (arr[i] == 1 || ((j = i - cnt) >= 0 && arr[j] == 1)) ans++;
                else break;
            }
        } else { // left
            for (int i = 0, j; i < n; i++) {
                if (arr[i] == 1 || ((j = i + cnt) < n && arr[j] == 1)) ans++;
                else break;
            }
        }
        return ans == n;
    }
}
