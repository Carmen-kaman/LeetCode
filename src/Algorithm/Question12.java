package Algorithm;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-23 18:28
 */
public class Question12 {
    public static void main(String[] args) {
        System.out.println("12" + "34");
        System.out.println("34" + "12");
    }

    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        if (map.containsKey(num)) return map.get(num);

        String roman = "";
        int time = 0;
        while (num != 0) {
            int curr = (num % 10) * time;

        }
        return null;
    }
}
