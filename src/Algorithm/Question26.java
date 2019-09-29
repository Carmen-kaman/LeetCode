package Algorithm;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-28 22:38
 */

//Given a sorted array nums, remove the duplicates in-place such that
//        each element appear only once and return the new length.
//        Do not allocate extra space for another array,
//        you must do this by modifying the input array in-place with O(1) extra memory.
public class Question26 {
    public static void main(String[] args) {
        int[] n = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Question26().removeDuplicates(n));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1){
            return nums.length;
        }else {
            int res = 0;
            int marker = Integer.MAX_VALUE;
            int j = -1;
            for (int i = 0; i < nums.length; i++) {
                if (res == 0){
                    ++res;
                    j = i;
                    marker = nums[i];
                }else {
                    if (nums[i] != marker){
                        ++res;
                        marker = nums[i];
                        nums[j+1] = nums[i];
                        ++j;
                    }
                }
            }
            return res;
        }
    }
}
