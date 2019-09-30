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
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Question53().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0 ){
            return 0;
        }else if (nums.length ==1){
            return nums[0];
        }else {
            int max = -1;
            int marker = 0;
            int tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                if (tmp + nums[i] < 0){
                    i = marker;
                    if (max < tmp){
                        max = tmp;
                        tmp = 0;
                        ++marker;
                    }
                }else {
                    tmp = tmp+nums[i];
                }
            }
            return (max > tmp)?max:tmp;

        }
    }
}
