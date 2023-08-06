package leetcode;

import java.util.*;

public class P6925 {
    public static String finalString(String s) {
        StringBuilder res = new StringBuilder();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (ch == 'i') {
                res = res.reverse();
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(finalString(in.next()));
    }
}
