
//能将字符串转换成整数
//输入: "4193 with words"
//输出: 4193


public class a8_myAtoi {

//    这是第一种方法，因为转化成了数组，所以比较耗时，可跳过不看
    public int myAtoi(String str) {
        str = str.trim();
        String[] split = str.split("");
        StringBuilder sb = new StringBuilder();
        if(split[0].matches("[\\d-+]")){
            sb.append(split[0]);
            for(int i=1;i<str.length();i++){
                if(split[i].matches("\\d")){
                    sb.append(split[i]);
                }else{
                    break;
                }
            }
            String s = sb.toString();
            int i;
            if(s.equals("-")||s.equals("+"))
                return 0;
            try {
                i = Integer.parseInt(s);
            }catch (Exception e){
                if(s.charAt(0)=='-')return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            return i;
        }else {
            return 0;
        }
    }

//    第二个方法因为在原数substring取，耗时短
    public int myAtoi2(String str) {
//        去掉头尾空格
        str = str.trim();
        String s = "";
//        为空
        if(str.equals(""))return 0;
//        取出非空的第一个字符
        char first = str.charAt(0);
        if(first=='+'||first=='-'||(first>='0'&&first<='9')){
            s = str.substring(0,1);
//            往后遍历（题目要求是连续数字，所以只要不是数字就可跳出循环）
            for(int i=1;i<str.length();i++){
                int num = str.charAt(i);
                if(num>='0'&&num<='9'){
                    s = str.substring(0,i+1);
                }else{
                    break;
                }
            }
            int i;
//            只有符号的情况
            if(s.equals("-")||s.equals("+"))
                return 0;
//            异常抛出
            try {
                i = Integer.parseInt(s);
            }catch (Exception e){
                if(s.charAt(0)=='-')return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            return i;
        }else
            return 0;
    }
    public static void main(String[] args) {
        a8_myAtoi my = new a8_myAtoi();
        int i = my.myAtoi2("  0000000000012345678");
        System.out.println(i);
    }
}
