
public class a28_strStr {
    public int strStr(String haystack, String needle) {
//        pat长度
        int m=needle.length();
//        txt长度
        int n=haystack.length();
        if(m==0)return 0;
        if(n==0)return -1;
//        遇到下一个字母跳到什么状态，前者为当前状态，后者为字母
        int dp[][]=new int[m][256];
//        遇到第一个字母状态为1
        dp[0][needle.charAt(0)]=1;
//        影子的状态
        int x=0;
//        构建dp状态表
        for(int i=1;i<m;i++) {
            for (int j = 0; j < 256; j++) {
//                默认全部都是要去看影子（x比j小1）
                dp[i][j] = dp[x][j];
            }
//            遇到符合字母，状态+1
            dp[i][needle.charAt(i)] = i + 1;

//            更新影子
//            因为x一开始是0，所以只要pat后面字母与pat开头字母一样，就会更新x
//            如果pat=abab，dp[0][a]一开始就是1，x初始是0，直到needle.charAt(2)又是a，x就是刚才的1了，
//            然后dp[1][b]本来也状态+1，即2，这里遇到needle.charAt(3)b了，所以x又变为2
            x = dp[x][needle.charAt(i)];
        }

//        构造dp完成，开始search
//        用pat去匹txt

//        初始状态为0
        int s = 0;
        for(int i=0;i<n;i++){
            s=dp[s][haystack.charAt(i)];
            if(s==m)
                return i-m+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        a28_strStr a28 = new a28_strStr();
        System.out.println(a28.strStr("hello","ll"));
    }
}
