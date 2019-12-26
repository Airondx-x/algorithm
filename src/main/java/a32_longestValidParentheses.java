import java.util.Map;
import java.util.Stack;

public class a32_longestValidParentheses {

//    动态规划
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
//            如果为（，肯定为0
            if (s.charAt(i) == ')') {
//                如果是（）情况
                if (s.charAt(i - 1) == '(') {
//                    大于2则表明前面有数，拿出前面的dp+2；否则就是只有他们两个符合，算0+2
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                 如果是（（或者））这种情况
//          i - dp[i - 1] > 0   表明去掉前面已知的()后，前面还有括号可以匹配（避免后面空指针异常）
//          s.charAt(i - dp[i - 1] - 1) == '('   表明这个符号是（，可以匹配的
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//          首先肯定要用dp[i - 1]
//          然后再判断，如果上面找到的（前面还有数，就加上前面数的dp，也就是dp[i-dp[i-1]-2]
//                    这里i是当前位置，减去前面的n个（）即dp[i-1]，然后-1包括了和i对应的左括号，再-1跳到前面的dp，所以总共-2
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
//                更新max
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


//      栈方法
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
//        放一个开始下标，计算长度
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
//            碰到(push
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
//                碰到）都先弹一个括号
                stack.pop();
//                如果为空，证明刚才不是（，不用算长度，把当前）作为新开始push进去
                if (stack.empty()) {
                    stack.push(i);
                } else {
//                不为空，证明刚才是（，拿出顶端的，用当前位置-开始位置得到长度
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

//      左右扫描法
    public int longestValidParentheses3(String s) {
        int maxns = 0;
        int left = 0,right = 0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='(')
                left++;
            else
                right++;
            if(left==right)
                maxns = Math.max(left*2,maxns);
            else if(right>left)
                left=right=0;
        }
        left=0;right=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')')
                right++;
            else
                left++;
            if(left==right)
                maxns = Math.max(left*2,maxns);
            else if(left>right)
                left=right=0;
        }
        return maxns;
    }


    public static void main(String[] args) {
        a32_longestValidParentheses a32 = new a32_longestValidParentheses();
        String str = "()((())";
        System.out.println(a32.longestValidParentheses3(str));
    }
}
