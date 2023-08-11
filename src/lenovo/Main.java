package lenovo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        String str = in.next();
        int[] l = new int[q];
        for (int i=0; i<q; i++) {
            l[i] = in.nextInt()-1;
        }
        int[] r = new int[q];
        for (int i=0; i<q; i++) {
            r[i] = in.nextInt()-1;
        }
        int[] k = new int[q];
        for (int i=0; i<q; i++) {
            k[i] = in.nextInt();
        }
        String res = "";
        for (int i=0; i<q; i++) {
            if (k[i] == 1) {
                res = res + str.substring(l[i], r[i]+1);
            } else if (k[i] == 0) {
                res = str.substring(l[i], r[i]+1) + res;
            }
        }
        System.out.println(res);
    }
}
