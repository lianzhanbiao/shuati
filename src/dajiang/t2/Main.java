package dajiang.t2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 编写一个程序，模拟无人机的飞行路径。给定一个包含指令的字符串 (例如："RUDDLLUR")，
 * 每个指令代表无人机在二维平面上移动的方向（U：前、D：后、L：左、R：右），请计算无人机的最终坐标并输出。
 * */

class Solution {

    /* Write Code Here */
    public int[] calculateFinalPositi(String instructions) {
        int x = 0;
        int y = 0;
        for (int i=0; i<instructions.length(); i++) {
            if (instructions.charAt(i) == 'U') {
                y++;
            } else if (instructions.charAt(i) == 'D') {
                y--;
            } else if (instructions.charAt(i) == 'L') {
                x--;
            } else if(instructions.charAt(i) == 'R'){
                x++;
            }
        }
        int[] res = new int[]{x, y};
        return res;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        String instructions;
        try {
            instructions = in.nextLine();
        } catch (Exception e) {
            instructions = null;
        }

        res = new Solution().calculateFinalPositi(instructions);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}

