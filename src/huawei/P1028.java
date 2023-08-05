package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1、需要在字符串中查找第k个最小的Ascii字母。
 * 2、按照Ascii码值从小到大排序查找第k个最小ascii码的字母，如果k>长度，
 * 则输出最大ascii值的字母所在字符串的索引，
 */
public class P1028 {
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String str = cin.readLine();
        int k = Integer.parseInt(cin.readLine());
        char[] chars = str.toCharArray();
        List<Character> arr = new ArrayList<>();
        for (char aChar : chars) {
            arr.add(aChar);
        }
        // 从小到大排序
        Collections.sort(arr);
        // 如果k大于字符串长度，则输出最大ascii字母，如果不大于则输出第k个ascii字符
        char c = k >= arr.size() ?  arr.get(arr.size() - 1) : arr.get(k - 1);
        // 如果有重复则输出索引最小
        System.out.println(str.indexOf(c));
    }
}
