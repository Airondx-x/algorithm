public class a69_mySqrt {

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while(left<right){
            long mid = (left+right)>>>1;
            long res = mid*mid;
            if(res<x)
                left = mid+1;
            else
                right = mid;
        }
        if(right*right>x)
            right--;
        return (int)right;
    }

    public static void main(String[] args) {
        a69_mySqrt a69 = new a69_mySqrt();
        System.out.println(a69.mySqrt(2147395599));
    }
}
