
//Z字变形，将一个给定字符串根据给定的行数，进行Z字排序。
//        比如输入字符串为 "LEETCODEISHIRING" 行数为 4 时，排列如下：
//        L     D     R
//        E   O E   I I
//        E C   I H   N
//        T     S     G
//        输出: "LDREOEIIECIHNTSG"


public class a6_convert {

    public static String convert(String s, int numRows) {
//        如果一行，保持原样
        if (numRows == 1) return s;
        StringBuilder ret = new StringBuilder();

        int n = s.length();
//        按列遍历的变化长度（也就是Z的一条竖线和一条斜线）
        int cycleLen = 2 * numRows - 2;
//        按行遍历
        for (int i = 0; i < numRows; i++) {
//            同一行的下一个字母都横跨了cycleLen个字符（只是竖线部分）
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
//                加上斜线部分的字符，因为是反着的，所以j + cycleLen - i
                if (i != 0 && i != numRows - 1 && j + cycleLen - i< n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
        public static void main(String[] args) {
        String s ="LEETCODEISHIRING";
        System.out.println(convert(s,5));
    }
}
