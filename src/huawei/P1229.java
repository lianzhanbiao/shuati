package huawei;

import java.util.*;

public class P1229 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<List<Integer>> dependents = new ArrayList<>();
        dependents.add(new ArrayList<>());
        int[] indegree = new int[n+1];
        for (int i=1; i<=n; i++) {
            List<Integer> d = new ArrayList<>();
            int m = in.nextInt();
            for (int j=0; j<m; j++) {
                int x = in.nextInt();
                d.add(x);
                indegree[x]++;
            }
            dependents.add(d);
        }
        int res = 0;
        int deleted = 0;
        while(true) {
            List<Integer> toRemove = new ArrayList<>();
            for (int i=1; i<=n; i++) {
                if (indegree[i] == 0) {
                    deleted++;
                    toRemove.add(i);
                    indegree[i] = -1;
                }
            }
            if (toRemove.size() == 0) {
                break;
            }
            for (int i : toRemove) {
                List<Integer> d = dependents.get(i);
                for (int t : d) {
                    indegree[t]--;
                }
            }
            res++;
        }
        if (deleted == n) {
            System.out.println(res);
        } else {
            System.out.println(-1);
        }
    }
}
