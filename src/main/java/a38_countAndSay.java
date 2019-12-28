public class a38_countAndSay {

    public String countAndSay(int n) {
        int count = 1;
        String curr = "1";
        for(int c=2;c<=n;c++){
            String res = "";
           for (int i = 0; i < curr.length(); i++) {
               if (i + 1 > curr.length() - 1 || curr.charAt(i + 1) != curr.charAt(i)) {
                   res+= (count + "") + (curr.charAt(i) + "");
                   count = 1;
               } else {
                   count++;
               }
           }
           curr = res;
       }
       return curr;
    }


    public static void main(String[] args) {
        a38_countAndSay a38 = new a38_countAndSay();
        System.out.println(a38.countAndSay(1));
    }
}
