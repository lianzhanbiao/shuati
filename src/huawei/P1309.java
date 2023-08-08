package huawei;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class P1309 {
    static class Node implements Comparable<Node> {
        int cnt; // 重复多少次
        int val; // 值

        public Node(int cnt, int val) {
            this.cnt = cnt;
            this.val = val;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.val, other.val);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Queue<Node> q = new PriorityQueue<>();
        Queue<Node> tmp = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            int cnt = scanner.nextInt();
            int val = scanner.nextInt();
            q.offer(new Node(cnt, val));
            int rest = n; // rest为输出某一字符后，剩余的长度，初始为n
            while (rest > 0) {
                if (q.isEmpty()) break; // 大根堆里已经没有字符了，直接break
                // 取出堆顶
                Node a = q.poll();
                // 输出 min(rest,a.cnt) 次
                for (int j = 0; j < Math.min(rest, a.cnt); j++) {
                    System.out.print(a.val);
                }
                // 从堆里取出来放到临时队列中
                tmp.offer(a);
                rest -= a.cnt;
            }
            while (!tmp.isEmpty()) {
                // 将队列中的数据重新放回堆中
                q.offer(tmp.poll());
            }
            System.out.println();
        }
    }
}