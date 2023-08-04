package huawei;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.*;

public class P1164 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // cache的大小
        int x = in.nextInt(); // x次访问
        int[] urls = new int[x]; // 访问的url id 一共访问x次
        for (int i=0; i<x; i++) {
            urls[i] = in.nextInt();
        }
        int y = in.nextInt(); // 设置y个url的ttl
        Map<Integer, Integer> ttls = new HashMap<>();
        Set<Integer> cache = new HashSet<>(); // 记录cache中的url
        for (int i=0; i<y; i++) {
            ttls.put(in.nextInt(), in.nextInt());
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]==b[1]?a[0]-b[0]:a[1]-b[1]); // 三个数字的数组，次序、ttl、url
        int[] res = new int[x];
        for (int i=0; i<x; i++) {
            while (!pq.isEmpty() && pq.peek()[1] <= i) {
                cache.remove(pq.peek()[2]);
                pq.poll();
            }
            if (cache.contains(urls[i])) {
                res[i] = 0;
            } else {
                res[i] = 1;
                if (pq.size() == n) {
                    cache.remove(pq.poll()[2]);
                }
                int[] add = new int[]{i, i+ttls.getOrDefault(urls[i], 5), urls[i]};
                cache.add(urls[i]);
                pq.offer(add);
            }
        }
        for(int f : res) {
            System.out.print(f+" ");
        }
    }
}
