import java.util.ArrayList;
import java.util.List;
//给定n个()生成所有可能的并且有效的括号组合。
//输入3
//输出：
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"

public class a22_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res,"",0,0, n);
        return res;
    }

    public void backtrack(List<String> res ,String str,int open,int close,int max) {
//       长度符合
        if(str.length()==max*2){
            res.add(str);
            return;
        }
//        max也就是表示有多少个(),也可以直接拿来表示多少个"（"或者"）"
        if (open < max)
            backtrack(res, str+"(", open+1, close, max);
//        符合这个条件就是有效的()表达式
        if (close < open)
            backtrack(res, str+")", open, close+1, max);
    }

    public static void main(String[] args) {
        a22_generateParenthesis a22 = new a22_generateParenthesis();
        List<String> list = a22.generateParenthesis(3);
        for (String s:list) {
            System.out.println(s);
        }
    }
}
