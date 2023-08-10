package huawei;

import java.util.*;

public class P1217 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int[] count = new int[n];
        int[] heights = new int[120];
        for (int i=n-1; i>=0; i--) {
            int h = arr[i];
            for (int j=40; j<=h; j++) {
                count[i] += heights[j];
            }
            heights[h]++;
        }
        for (int i=0; i<n-1; i++) {
            System.out.print(count[i]+" ");
        }
        System.out.print(count[n-1]);
    }
}
