
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。则其数值范围为 [−231,  231 − 1]。如果反转后整数溢出那么就返回 0。
//        输入: -123
//        输出: -321

public class a7_reverse {
    public int reverse(int x) {
//        计算结果
        int rev = 0;
//        每次处理一位数
        while(x!=0){
//            取出个位数
            int pop = x%10;
//            进行下一次循环
            x/=10;
//            因为有则其数值范围为 [−2*31,  2*31 − 1]，与int最大最小值相等
//            再*10前先判断是否超过范围，||后者防止单独个位数部分超过范围，但其实不会发生，因为符合这种情况，
//            最后一位要>7，或者<-8，但int最大最小开头只会是1或2，所以可以不写这个条件，但如果传入值是String类型就需要这个条件了。
            if(rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>Integer.MAX_VALUE%10))return 0;
            if(rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<Integer.MIN_VALUE%10))return 0;
//           加上新的位数
            rev = rev *10 + pop;
        }
        return rev;
    }

////        直接字符串操作，不说
//    public int reverse2(int x){
//        String s = String.valueOf(x);
//        StringBuilder sb = new StringBuilder();
//        if(x>=0){
//            for(int i=s.length()-1;i>=0;i--){
//                sb.append(s.charAt(i));
//            }
//        }else{
//            sb.append(s.charAt(0));
//            for(int i=s.length()-1;i>0;i--){
//                sb.append(s.charAt(i));
//            }
//        }
//        int result;
//        try {
//            result = Integer.parseInt(sb.toString());
//        }catch (Exception e){
//            return 0;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        a7_reverse rs = new a7_reverse();
        System.out.println(rs.reverse(-1234));
    }
}
