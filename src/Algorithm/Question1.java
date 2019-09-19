package Algorithm;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-19 18:27
 */
public class Question1 {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        Question1 question1 = new Question1();
        System.out.println(question1.twoSum(array, target)[0]+" "+ question1.twoSum(array, target)[1]);
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        System.out.println("There is no result for this question!!!");
        return null;
    }

}
