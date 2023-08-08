package huawei;

import java.util.*;

public class P1293 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int v = in.nextInt();
        int m = in.nextInt();
        for (int i=0; i<m; i++) {
            int id = in.nextInt();
            int x = id / h;
            int y = id % h;
            if (x == 0) {
                System.out.print(id + h*(v-1) + " ");
            } else {
                System.out.print(id - h + " ");
            }
            if (y > 0) {
                System.out.print(id-1 + " ");
            }
            if ( x == v-1) {
                System.out.print(y+" ");
            } else {
                System.out.print(id + h + " ");
            }
            if (y < h-1) {
                System.out.print(id+1+" ");
            }
            System.out.print(id);
            System.out.println();
        }
    }
}
