package Algorithm;

import java.util.ArrayList;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-20 00:00
 */

//Given a string, find the length of the longest substring without repeating characters.
public class Question3 {
    public static void main(String[] args) {
        System.out.println(new Question3().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int tmp = 1;
        int index = 0;
        if (s.length() == 0){
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        } else {
            char[] str = s.toCharArray();
            for (int i = 1; i < str.length; i++) {
                if (!s.substring(index, i).contains(String.valueOf(str[i]))) {
                    ++tmp;
                } else {
                    ++index;
                    i = index - 1;
                    longest = (tmp > longest) ? tmp : longest;
                    tmp = 0;

                }
            }
            longest = (tmp > longest) ? tmp : longest;
        }
//        tmp longer than longest then return tmp;
        return longest;
    }
}
