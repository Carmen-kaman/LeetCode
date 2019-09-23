package Algorithm;

import java.lang.invoke.LambdaConversionException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-23 17:50
 */
public class Question14 {
    public static void main(String[] args) {
        String[] strings = {"flower","flow"};
        System.out.println(new Question14().solution(strings));
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs.length == 0) {
            return prefix;
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            Arrays.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });

//            Lambda
//            Arrays.sort(strs, (s1, s2)->Integer.compare(s1.length(),s2.length()));
            for (int i = 0; i < strs[0].length(); i++) {
                char curr = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    char check = strs[j].charAt(i);
                    if (!(check == curr)){
                        return prefix;
                    }
                }
                prefix += String.valueOf(curr);
            }
        }
        return prefix;
    }

    public String solution (String[] strs){
        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
