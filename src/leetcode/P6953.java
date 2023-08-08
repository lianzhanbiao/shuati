package leetcode;

import java.util.*;

public class P6953 {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size() < 3) return true;
        return dfs(nums, 0, nums.size()-1, m);
    }
    public boolean dfs (List<Integer> nums, int start, int end, int m) {
        int minIndex = start;
        int sum = 0;
        for (int i=start; i<=end; i++) {
            sum += nums.get(i);
            if (nums.get(i) < minIndex) {
                minIndex = i;
            }
        }
        if (sum < m) {
            return false;
        }
        if (start >= end-1) {
            return true;
        }
        boolean a = dfs(nums, start+1, end, m);
        boolean b = dfs(nums, start, end-1, m);
        boolean c = dfs(nums, start, minIndex-1, m) && dfs(nums, minIndex+1, end, m);
        return a || b || c;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        System.out.println(new P6953().canSplitArray(list, 5));
    }
}
