package Algorithm;

import java.util.HashMap;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-22 12:34
 */
//Roman to Integer (range 1-3999)
public class Question13 {
    public static void main(String[] args) {
        System.out.println(new Question13().romanToInt("MMMCMXCIX"));
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        if (s.length() == 1) {
            return map.get(s.charAt(0));
        } else {
            boolean mode = false; // "-
            int sum = 0;
            int child = 0;
            for (int i = s.length()-1; i >= 0; i--) {
                int curr = map.get(s.charAt(i));
                if (i == s.length()-1){
                    sum += curr;
                    child = curr;
                }else {
                    if (curr < child){
                        sum -= curr;
                    }else {
                        sum += curr;
                    }
                    child = curr;
                }
            }
            return sum;
        }
    }
}


