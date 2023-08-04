package huawei;

import java.util.*;

public class P1003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();;
        int sum = 0;
        int kozi = Integer.MAX_VALUE;
        int tazi = 0;
        for (int i=0; i<n; i++) {
            int weight = scanner.nextInt();
            tazi += weight;
            sum ^= weight;
            kozi = Math.min(kozi, weight);
        }
        if (sum == 0) {
            System.out.println(tazi - kozi);
            return;
        }
        System.out.println("NO");
    }
}
