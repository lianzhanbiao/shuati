package meituan;

import java.util.*;

/**
 * 当我们反复进行k次操作之后，如果“剩下的数组”（也就是原数组去掉个最小值和个最大值后的结果）已经有序，
 * 便没有继续进行操作的必要（如果继续进行，“剩下的数组”必然有序），此时的k就是我们寻找的答案。
 * */
public class P1288 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[in.nextInt() - 1] = i;
        }

        int l = (n - 1) / 2;
        int r = n / 2;

        if (nums[l] <= nums[r]) {
            while (l > 0 && nums[l - 1] < nums[l] && nums[r + 1] > nums[r]) {
                l--;
                r++;
            }
            System.out.println(l);
        } else {
            System.out.println((n & 1) == 0 ? l + 1 : l);
        }
    }
}
