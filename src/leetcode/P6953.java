package leetcode;

import java.util.*;

public class P6953 {
    public boolean canSplitArray(List<Integer> nums, int m) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        int right = nums.size()-1;
        while (left < right-1) {
            if (nums.get(left) < nums.get(right)) {
                sum -= nums.get(left);
                left++;
            } else {
                sum -= nums.get(right);
                right--;
            }
            if (sum < m) {
                return false;
            }
        }
        return true;
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
