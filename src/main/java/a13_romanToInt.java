//同上题   罗马字符转数字
//        输入: "LVIII"
//        输出: 58
//        解释: L = 50, V= 5, III = 3.
public class a13_romanToInt {
    public int romanToInt(String s) {
//        上题抄过来
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int num=0;
        int i=0,j=0;
//        遍历全部罗马字符（这个循环里面其实还有一套str的循环，因为罗马字符肯定是按照str排好的顺序组成）
        while (j<s.length()){
//            首先拿出2个字符在str里查有没有
            if(j+2<=s.length()&&s.substring(j, j + 2).equals(str[i])){
                num+=values[i];
                j+=2;
//                2个字符不符合，再匹配单字符的
            }else if(s.substring(j, j + 1).equals(str[i])){
                num+=values[i];
                j+=1;
            }else{
//                都不匹配，说明这个str[i]没有用到，匹配下一个即str[i+1]
                i++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        a13_romanToInt a13 = new a13_romanToInt();
        String str = "MCMXCIV";
        System.out.println(a13.romanToInt(str));

    }

}
