package huawei;

import java.util.*;

public class P1006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();;
        int tot = scanner.nextInt();;
        int sum = 0;
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        if (sum <= tot) {
            System.out.println(-1);
            return;
        }
        int l = 0;
        int r = arr[n-1];;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            int tempSum = getSum(arr, mid);
            if (tempSum <= tot) {
                l = mid;
            } else {
                r--;
            }
        }
        System.out.println(l);
    }
    public static int getSum(int[] arr, int x) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += Math.min(arr[i], x);
        }
        return sum;
    }
}
