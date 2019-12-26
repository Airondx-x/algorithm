//数字转罗马字符
//    字符          数值
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//通常大的字母在左，小的字母在右，但是如果是4，9，40，90这种，小的字母在左，大的字母在右


public class a12_intToRoman {
    public String intToRoman(int num) {
//        贪心算法，相当于换零钱
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res = "";
        for(int i=0;i<values.length;i++){
//            算出当前最大额可以除多少次，相当于3999的3
            int a = num/values[i];
            if(a==0)continue;
//            有多少个1000就加多少次
            for(int j=0;j<a;j++){
                res += str[i];
            }
//            去掉刚才的3000
            num%=values[i];
        }
        return res;
    }

    public static void main(String[] args) {
        a12_intToRoman a12 = new a12_intToRoman();
        System.out.println(a12.intToRoman(2994));
    }
}
