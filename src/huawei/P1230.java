package huawei;

import java.util.*;

public class P1230 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int t = in.nextInt();
        int[] mark = new int[100002];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=l; i<=r; i++) queue.add(i);
        for (int i=0; i<t; i++) {
            int op = in.nextInt();
            if (op == 1) {
                int num = in.nextInt();
                if (num <= queue.size()) {
                    for (int j=0; j<num; j++) {
                        int firstFree = queue.poll();
                        mark[firstFree] = 1;
                    }
                }
            } else if (op == 2) {
                int id = in.nextInt();
                if (queue.size() > 0 && (id >= l && id <= r) && mark[id] == 0) {
                    mark[id] = 1;
                    queue.remove(id);
                }
            } else {
                int id = in.nextInt();
                if ((id >= l && id <= r) && mark[id] == 1) {
                    mark[id] = 0;
                    queue.offer(id);
                }
            }
        }
        System.out.println(queue.peek());
    }
}
