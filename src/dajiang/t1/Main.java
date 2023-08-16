package dajiang.t1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    /* Write Code Here */
    public int[] ThreeDigitNumbers (int[] selectedDigits) {
        Arrays.sort(selectedDigits);
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (j == i) continue;
                for (int k=0; k<5; k++) {
                    if (k == j || k == i) continue;
                    list.add(i*100+j*10+k);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i=0; i<res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int selectedDigits_size = 0;
        selectedDigits_size = in.nextInt();
        int[] selectedDigits = new int[selectedDigits_size];
        for(int selectedDigits_i = 0; selectedDigits_i < selectedDigits_size; selectedDigits_i++) {
            selectedDigits[selectedDigits_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = new Solution().ThreeDigitNumbers (selectedDigits);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
