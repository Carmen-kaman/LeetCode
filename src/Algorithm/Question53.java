package Algorithm;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-29 22:59
 */

//Given an integer array nums, find the contiguous subarray (containing at least one number)
//        which has the largest sum and return its sum.

public class Question53 {
    public static void main(String[] args) {
        int[] nums = {-2,-1};
        System.out.println(new Question53().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0 ){
            return 0;
        }else if (nums.length ==1){
            return nums[0];
        }else {
            int max = Integer.MIN_VALUE;
            int tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                tmp = tmp + nums[i];
                if (max < tmp){
                    max = tmp;
                }
                if (tmp < 0){
                    tmp = 0;
                }
            }
            return max;

        }
    }
}
