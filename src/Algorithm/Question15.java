package Algorithm;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-21 14:03
 */
//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
//        Find all unique triplets in the array which gives the sum of zero.
public class Question15 {
    public static void main(String[] args) {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        Arrays.sort(nums);
        List<List<Integer>> res = new Question15().threeSum(nums);
        for (List<Integer> tmp : res) {
            System.out.println(tmp.toString());
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3) {
            return res;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                Sum(nums, i + 1, nums.length - 1, nums[i], res);
            }
        }
        return res;
    }

    public void Sum(int[] nums, int head, int tail, int first, List<List<Integer>> res) {
        while (head < tail) {
            if (nums[head] + nums[tail] + first == 0) {
                List<Integer> tmp = new LinkedList<>();
                ((LinkedList<Integer>) tmp).addLast(first);
                ((LinkedList<Integer>) tmp).addLast(nums[head]);
                ((LinkedList<Integer>) tmp).addLast(nums[tail]);
                res.add(tmp);
                while (head < tail && nums[head] == nums[head + 1]) ++head;
                while (head < tail && nums[tail] == nums[tail - 1]) --tail;
                ++head;
                --tail;
            }else if (nums[head] + nums[tail] + first < 0){
                ++head;
            }else {
                --tail;
            }
        }
    }
}