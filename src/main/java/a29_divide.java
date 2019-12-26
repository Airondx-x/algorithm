//这题跳过吧
public class a29_divide {
    public int divide(int dividend, int divisor) {
        int ans = -1;
        int sign = 1;
        if (dividend > 0) {
            sign = opposite(sign);
            dividend = opposite(dividend);
        }
        if (divisor > 0) {
            sign = opposite(sign);
            divisor = opposite(divisor);
        }

        int origin_dividend = dividend;
        int origin_divisor = divisor;
        if (dividend > divisor) {
            return 0;
        }

        dividend -= divisor;
//        因为循环加n次divisor太慢了，我们每次可以把divisor加倍
//此时我们传进的是两个负数，正常情况下，它就返回正数，但我们是在用负数累加，所以要取相反数
        while (divisor >= dividend) {
            ans = ans + ans;
            divisor += divisor;
            dividend -= divisor;
        }
//      当前次数 再加上 去递归超出了的部分
        int a = ans + opposite(divide(origin_dividend - divisor, origin_divisor));
//        超出了范围
        if (a == Integer.MIN_VALUE) {
            if (sign > 0) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            if (sign > 0) {
                return opposite(a);
            } else {
                return a;
            }
        }
    }

    public int opposite(int x) {
        return ~x + 1;
    }

    public static void main(String[] args) {
        a29_divide a29 = new a29_divide();
        int divide = a29.divide(7, 2);
        System.out.println(divide);
    }
}
