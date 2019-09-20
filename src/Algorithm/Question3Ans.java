package Algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-20 12:49
 */

public class Question3Ans {

    public static void main(String[] args) {
        System.out.println(new Question3Ans().slidingWindowOpt("pwwkew"));
    }

    public int slidingWindow(String s) {
        int start = 0, end = 0, ans = -1, length = s.length();
        Set<Character> longest = new HashSet<>();
        char[] str = s.toCharArray();

        while (start < length && end < length) {
            if (!longest.contains(str[end])) {
                longest.add(str[end]);
                ++end;
                ans = Math.max(ans, end - start);
            } else {
                longest.remove(str[start++]);
            }
        }
        return ans;
    }

    //  using hash map
    public int slidingWindowOpt(String s) {
        int ans = 0, length = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0, i = 0; j < length; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }

}
