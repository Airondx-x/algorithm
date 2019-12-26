//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//输入: "()[]{}"
//输出: true
//输入: "([)]"
//输出: false
//输入: "{[]}"
//输出: true

import java.util.*;

public class a20_isValid {

//    优化成一次遍历
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            如果是左括号，push进去，不做处理
            if (!map.containsKey(c))
                stack.push(c);
//            如果是右括号，拿出栈顶的括号 看是否匹配
            else{
                if(stack.isEmpty()||stack.pop()!=map.get(c))
                    return false;
            }
        }
//            还有没有多余的括号
        if(stack.isEmpty())return true;
        else return false;
    }


    public static void main(String[] args) {
        a20_isValid a20 = new a20_isValid();
        String s = "()[]{}";
        String s1 = "]";
        System.out.println(a20.isValid(s));
    }
}
