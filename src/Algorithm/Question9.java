package Algorithm;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-21 13:19
 */

//Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
public class Question9 {

    public static void main(String[] args) {
        System.out.println(new Question9().isPalindrome(11));
    }

    public boolean isPalindrome(int x) {
        if (x >= 0 && x< 10){
            return true;
        }else if (x < 0){
            return false;
        }else {
            char[] str = String.valueOf(x).toCharArray();
            int len = str.length/2, head = 0, tail = str.length-1;
            while (len >= 0){
                if (str[head] == str[tail]){
                    ++head;
                    --tail;
                    --len;
                }else {
                    return false;
                }
            }
            return true;
        }
    }
}
