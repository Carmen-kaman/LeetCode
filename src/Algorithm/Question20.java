package Algorithm;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author jiamin_he
 * @version 2.0
 * @since 2019-09-27 22:31
 */

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Note that an empty string is also considered valid.

public class Question20 {
    public static void main(String[] args) {
        System.out.println(new Question20().isValid("]]"));
    }

    public boolean isValid(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return true;
        } else {
            Stack<Character> res = new Stack<>();
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (res.isEmpty()){
                    res.push(c[i]);
                }else if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                    res.push(c[i]);
                } else {
                    char tmp = res.peek();
                    switch (c[i]) {
                        case ')':
                            if (tmp == '(') {
                                res.pop();
                            } else {
                                res.push(c[i]);
                            }
                            break;
                        case ']':
                            if (tmp == '[') {
                                res.pop();
                            } else {
                                res.push(c[i]);
                            }
                            break;
                        case '}':
                            if (tmp == '{') {
                                res.pop();
                            } else {
                                res.push(c[i]);
                            }
                            break;
                        default:
                            res.push(c[i]);
                            break;
                    }
                }
            }
            System.out.println(res.size());
            return res.isEmpty();
        }

    }

    public boolean solution(String s){
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)){
                char topElement = stack.empty()?'#':stack.pop();
                if (topElement != map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
