package huawei;

import java.util.Scanner;

public class P1027 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int n = str.length();
        int[] arr = new int[n];
        arr[0]=1;
        arr[1]=2;
        arr[2]=4;
        for (int i=3; i<n; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
            arr[i] = arr[i] % 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append((char) ((str.charAt(i) - 'a' + arr[i]) % 26 + 'a'));
        }
        System.out.println(sb.toString());
    }
}
