package Algorithm;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-20 13:30
 */

//Given a 32-bit signed integer, reverse digits of an integer.
//    must consider MAX VALUE
public class Question7 {
    public static void main(String[] args) {
        System.out.println(new Question7().reverse(-2147483647));
    }

    public int reverse(int x) {
        if (x > -10 && x < 10) {
            return x;
        } else {
            int negative = (x > 0) ? 1 : -1;
            if (x ==Integer.MIN_VALUE || x == Integer.MAX_VALUE){
                return 0;
            }
            return getNum(Math.abs(x), 0, negative) * negative;
        }
    }

    public int getNum(int num, int ans, int negative) {
        if (num < 10) {
            if (ans <= Integer.MAX_VALUE / 10) {
                if (negative > 0 && ans == Integer.MAX_VALUE / 10) return (num > 7) ? 0 : num + ans * 10;
                if (negative < 0 && ans == Integer.MAX_VALUE / 10) return (num > 8) ? 0 : num + ans * 10;
                ans = num + ans * 10;
                return ans;
            } else {
                return 0;
            }
        } else {
            int remainder = num % 10;
            ans = ans * 10 + remainder;
            return getNum(num / 10, ans, negative);
        }
    }

    public int solution(int x){
        int num = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            if (num > Integer.MAX_VALUE/10 ||
                    (num == Integer.MAX_VALUE/10 && pop >8))return 0;
            if (num < Integer.MIN_VALUE/10 ||
                    (num == Integer.MIN_VALUE/10 && pop<-8)) return 0;
            num = num *10 +pop;
        }
        return num;
    }

}
