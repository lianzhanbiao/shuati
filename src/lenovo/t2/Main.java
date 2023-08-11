package lenovo.t2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String str = in.next();
        char[] chs = str.toCharArray();
        String curMax = k+""+str;
        for (int i=1; i<n; i++) {
            if (str.charAt(i) >= k+'0') {
                String tmp = str.substring(0, i) + "" + k + str.substring(i);
                if (isValid(tmp) && grater(tmp, curMax)) {
                    curMax = tmp;
                }
            }
        }
        System.out.println(curMax);
    }
    public static boolean isValid(String s) {
        return s.charAt(0) != '0';
    }
    public static boolean grater(String s1, String s2) {
        // 比较两个字符串
        int len = s1.length();
        for (int i=0; i<len; i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return true;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
