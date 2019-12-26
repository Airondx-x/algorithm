
//判断一个整数是否是回文数
//        输入: 121
//        输出: true

public class a9_isPalindrome {
//    转字符串，不说
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int length = str.length();
        for(int i = 0; i< length /2; i++){
            if(str.charAt(i)!=str.charAt(length-1-i))
                return false;
        }
        return true;
    }

//    %10取数
    public boolean isPalindrome2(int x) {
//        负数有-号，或者0结尾的数（除0本身）都不为回文
        if(x<0||(x%10==0&&x!=0)) return false;
//        操作副本
        int copy = x;
//        有多少位数
        int tail = 1;
//        纯粹算多少位数
        while(copy>=10){
            copy /=10;
            tail*=10;
        }
//            不能因为12321，只剩下x=3就不用判断，就写为while(x<10)，因为可能x=0023（下面31行的情况）
        while(x!=0){
//            比较最前最后位数是否一样。最后可以x%10,最前就讲究了，1234/1000，所以需要上面算位数
            if(x%10!=x/tail) return false;
//            去掉前后各一位，这里其实有点东西，/10肯定只去掉了最后一位，但是%tail可能就去掉很多位了
//            比如（10023%10000=23）,但下一轮的时候因为x/tail=0所以取最前的位数其实还是0而不是2
            x=x%tail/10;
//            位数也要减掉两个0
            tail/=100;
        }
        return true;
    }

    public static void main(String[] args) {
        a9_isPalindrome a9 = new a9_isPalindrome();
        System.out.println(a9.isPalindrome2(100232001));
    }
}
