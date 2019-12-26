public class a38_countAndSay {
    String result = "";

    public String countAndSay(int n) {
        test("1",1,n);
        return result;
    }

    public void test(String num,int fir,int n){
        if(fir==n)
            result = num;
        else {
            String str = "" + num;
            String str2 = "";
            int count = 1;
            for (int i = 0; i < str.length(); i++) {
                if (i + 1 > str.length()-1 || str.charAt(i + 1) != str.charAt(i)) {
                    str2 += (count+"")+(str.charAt(i)+"");
                    count = 1;
                } else
                    count++;
            }
            test(str2, fir + 1, n);
        }
    }


    public static void main(String[] args) {
        a38_countAndSay a38 = new a38_countAndSay();
        a38.countAndSay(5);
    }
}
