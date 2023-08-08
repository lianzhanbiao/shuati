package huawei;

import java.util.*;

public class P1306 {

    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            addValue(in.nextInt());
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        for (int num : res) {
            System.out.print(num+" ");
        }
    }

    static void addValue(int v) {
        List<Integer> tmp = new ArrayList<>();
        int sum = v;
        while (sum > 0 && !stack.isEmpty()) {
            int p = stack.pop();
            sum -= p;
            tmp.add(p);
        }
        if (sum != 0) {
            for (int i=tmp.size()-1; i>=0; i--) {
                stack.push(tmp.get(i));
            }
            stack.push(v);
        } else {
            addValue(2*v);
        }
    }
}
