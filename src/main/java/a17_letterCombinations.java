import java.util.*;

//https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
//许久未见的回溯法 最简单的回溯
public class a17_letterCombinations {

//    字典作用，都用hashmap替代
    Map<String,String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String > output = new ArrayList<String>();

    public void backtrack(String str,String digits){
//        数字都递归完了，可以拿一个结果
        if(digits.length()==0){
//            加上这个结果
            output.add(str);
        }else{
//            取出第一个电话上的数字
            String di = digits.substring(0,1);
//            找到数字对应的字母
            String letters = map.get(di);
            for(int i=0;i<letters.length();i++){
//            遍历这个数字的字母 拿去组合
                String singletter = letters.substring(i,i+1);
//            递归，找找下一数字代表的字母
                backtrack(str+singletter,digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0){
            backtrack("",digits);
        }
        return output;
    }

    public static void main(String[] args) {
        a17_letterCombinations a17 = new a17_letterCombinations();
        List<String> list = a17.letterCombinations("23");
        for (String s:list) {
            System.out.print(s+" ");
        }
    }
}
