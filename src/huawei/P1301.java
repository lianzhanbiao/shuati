package huawei;

import java.util.*;

public class P1301 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i=0; i<n; i++) {
            String log = in.next();
        }
    }

    static boolean isLike(String s1, String s2) {
        int i=0;
        int j=0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
                continue;
            }
            if (s2.charAt(i) >= '0' && s2.charAt(i) <= '9') {
                continue;
            }
            if (s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
