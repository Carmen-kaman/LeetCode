package Algorithm;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-10-02 22:04
 */
//Given an array, rotate the array to the right by k steps,
//        where k is non-negative.
public class Question189 {

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7};
        new Question189().rotate(num, 3);
        System.out.println("...");
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i];
        }

        if (k % len != 0) {
            k = k % len;
            for (int i = 0; i < nums.length; i++) {
                int index = (i+k)%len;
                nums[i] = res[index];
            }

        }
    }

}
