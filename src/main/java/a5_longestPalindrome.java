
//字符串中找出最长回文子串
//        输入: "cbbd"
//        输出: "bb"

public class a5_longestPalindrome {
    public String longestPalindrome(String s) {
        String res = add(s);
        int[] halfLenArr = new int [res.length()];
        boolean flag;
        int maxLen = 0;
//        羽翼右边界
        int rightside = 0;
//        随着遍历移动的羽翼中心
        int rightcenter = 0;
//        记录最长回文串下标
        int maxcenter = 0;
//        遍历判断
        for(int i=0;i<res.length();i++){
            flag = true;
//          在右边界之内,可能不用中心扩展
            if(rightside>i) {
//            也就是中心下标-(i到中心下标的距离)==rightcenter-(i-rightcenter)
                int left = 2 * rightcenter - i; //这个地方纯数学，看楼上理解一下
//                这里微信收藏写错了
                if (i + halfLenArr[left] >= rightside) {/*不清楚后续字符是否回文，需要中心扩展*/
//                    赋 本身到边界的值（后续去扩展中心继续扩展比较）
                    halfLenArr[i] = rightside - i;
                } else {
                    /*在边界内，不需要中心扩展*/
                    halfLenArr[i] = halfLenArr[left];
                    flag=false;
                }
            }
//          超过了右边界,需要中心扩展
            if(flag) {
                while ((i - 1 - halfLenArr[i]) >= 0 && (i + 1 + halfLenArr[i] < res.length())) {
//                   回文的前1和后1相同
                    if (res.charAt((i - 1 - halfLenArr[i])) == res.charAt((i + 1 + halfLenArr[i]))) {
                        halfLenArr[i]++;
                    } else break;/*直到不是回文串*/
                }
//                更新边界和中心
                rightside = i + halfLenArr[i];
                rightcenter = i;
//            更新最大值
                if (halfLenArr[i] > maxLen) {
                    maxcenter = i;
                    maxLen = halfLenArr[i];
                }
            }
        }
//         去掉之前添加的#
        StringBuilder sb = new StringBuilder();
       for(int i=maxcenter-maxLen+1;i<=maxcenter+maxLen-1;i+=2){
           sb.append(res.charAt(i));
       }
        return sb.toString();
    }

    public String add(String str){
        StringBuilder sb = new StringBuilder();
        sb.append("*");
        for(int i=0;i<str.length();i++){
//            刚好循环到最后一个字符就跳出了  下标和长度的错位
            sb.append(str.charAt(i));
            sb.append("*");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "ccc";
        a5_longestPalindrome l = new a5_longestPalindrome();
        System.out.println(l.longestPalindrome(str));
    }
}