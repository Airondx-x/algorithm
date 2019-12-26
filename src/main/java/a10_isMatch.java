//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//        '.' 匹配任意单个字符
//        '*' 匹配零个或多个前面的那一个元素
//
//        s = "aa"
//        p = "a*"
//        输出: true

public class a10_isMatch {
public boolean isMatch(String text, String pattern) {
//    规则空了就结束了
    if (pattern.isEmpty()) return text.isEmpty();
//    比较第一个字符 1、文本为空，2、相等，3、'.'任意匹配
    boolean first_match = (!text.isEmpty() &&
            (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

//    有*的
    if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
//        递归1、*为0次的情况  2、*为1次的情况
        return (isMatch(text, pattern.substring(2)) ||
                (first_match && isMatch(text.substring(1), pattern)));
//    没*的，直接都截掉1位继续比
    } else {
        return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
}
//动态规划
    public boolean isMatch2(String s, String p) {
        int ls = s.length(), lp = p.length();
        boolean[][] dp = new boolean[ls + 1][lp + 1];
        dp[0][0] = true;
//        text为""的情况，只有*才可以，所以从第二位开始
        for(int j = 2; j <= lp; j++)
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        for(int i = 1; i <= ls; i++) {
            for(int j = 1; j <= lp; j++) {
                int m = i - 1, n = j - 1;
//                如果当前为*
                if(p.charAt(n) == '*')
//                    1是*为0次  2是*为1次
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] &&
                            (s.charAt(m) == p.charAt(n - 1) || p.charAt(n - 1) == '.');
//                不为*就直接对比
                else if(s.charAt(m) == p.charAt(n) || p.charAt(n) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[ls][lp];
    }
//      做实验，将ij相互调换，也是可以的
//    public boolean isMatch3(String s,String p){
//        int ls = s.length(), lp = p.length();
//        boolean[][] dp = new boolean[lp + 1][ls + 1];
//        dp[0][0] = true;
//        for (int i=2;i<=lp;i++){
//            dp[i][0]=dp[i-2][0]&&p.charAt(i-1)=='*';
//        }
//        for(int i = 1; i <= lp; i++) {
//            for(int j = 1; j <= ls; j++) {
//                int m = i - 1, n = j - 1;
////                如果当前为*
//                if(p.charAt(m) == '*')
////                    1是*为0次  2是*为1次
//                    dp[i][j] = dp[i-2][j] || dp[i][j-1] &&
//                            (s.charAt(n) == p.charAt(m - 1) || p.charAt(m - 1) == '.');
////                不为*就直接对比
//                else if(s.charAt(n) == p.charAt(m) || p.charAt(m) == '.')
//                    dp[i][j] = dp[i - 1][j - 1];
//            }
//        }
//        return dp[lp][ls];
//    }

    public static void main(String[] args) {
        a10_isMatch a10 = new a10_isMatch();
        String s = "a";/*字符串*/
        String p = "a*";/*字符规律*/
        System.out.println(a10.isMatch2(s,p));
    }
}
