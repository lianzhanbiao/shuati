package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class pp {
    int x, y;

    pp(int a, int b) {
        this.x = a;
        this.y = b;
    }
}

class cmp implements Comparator<pp> {
    public int compare(pp a, pp b) {
        if (a.x != b.x)
            return a.x - b.x;
        return a.y - b.y;
    }
}

class P1026 {
    public static void main(String[] args) {
        int[] cnt = new int[505];
        int M, num;
        String str;
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        num = scanner.nextInt();
        str = scanner.next();
        int nowcnt = 0; // 记录当前更新的第几个字符
        for (int j = 0; j < str.length(); j++) {
            int t = str.charAt(j);
            cnt[t]++;
            nowcnt++;
            if (nowcnt == num) { // 如果记录的数量到达应该计算的增量时统计答案
                List<pp> tmparr = new ArrayList<>();
                // 依次遍历数字，小写字母，大写字母，存入临时数组中
                for (int i = 'a'; i <= 'z'; i++) {
                    tmparr.add(new pp(cnt[i], i));
                }
                for (int i = 'A'; i <= 'Z'; i++) {
                    tmparr.add(new pp(cnt[i], i));
                }
                for (int i = '0'; i <= '9'; i++) {
                    tmparr.add(new pp(cnt[i], i));
                }
                // 重载排序按第一维数量排，第一维相等时按第二维字母ascii码排
                Collections.sort(tmparr, new cmp());
                // 统计前 m 个输出
                int tmp = M;
                while (tmparr.size() > 0 && tmp != 0) {
                    tmp--;
                    System.out.print((char) tmparr.get(tmparr.size() - 1).y);
                    tmparr.remove(tmparr.size() - 1);
                }
                nowcnt = 0;
            }
        }
    }
}