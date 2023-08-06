package huawei;

import java.util.*;

public class P1189 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String[] strs = s1.toString().split(" ");
        long[] arr = new long[strs.length];
        int i=0;
        for (String s : strs) {
            arr[i++] = Integer.parseInt(s);
        }
        long cnt = in.nextLong();
        Arrays.sort(arr);
        long left = 0;
        long right = arr[arr.length-1];
        while (left < right) {
            long middle = (left+right+1)/2;
            if (getSUm(arr, middle) > cnt) {
                right = middle-1;
            } else {
                left = middle;
            }
        }
        if (left == arr[arr.length-1]) {
            System.out.println(-1);
        } else {
            System.out.println(left);
        }
    }
    public static long getSUm(long[] arr, long value) {
        long sum = 0;
        for (long num : arr) {
            sum += Math.min(num, value);
        }
        return sum;
    }
}
