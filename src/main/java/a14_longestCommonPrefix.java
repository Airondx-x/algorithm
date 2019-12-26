//查找字符串数组中的最长公共前缀。
//输入: ["flower","flow","flight"]
//输出: "fl"
public class a14_longestCommonPrefix {
//  拿长度最短的元素去作为公共前缀，和其他字符串每个位置比较，成功append，失败结束
    public String longestCommonPrefix(String[] strs) {
        int min=Integer.MAX_VALUE;
        int index = 0;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<min) {
                min = strs[i].length();
                index = i;
            }
        }
        if(min==0||strs.length==0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs[index].length();i++){
            char tar = strs[index].charAt(i);
            boolean flag = true;
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=tar){
                    flag = false;
                    break;
                }
            }
            if(flag)sb.append(tar);
            else break;
        }
        return sb.toString();
    }

//    二分法
    public String longestCommonPrefix2(String[] strs) {
        int min=Integer.MAX_VALUE;
//        最小长度
        for(String s:strs){
            min=Math.min(min,s.length());
        }
//        出现空情况
        if(min==0||strs.length==0) return "";
        int low=0,high=min;
//        有=是为了数组字符串长度为1的情况
        while(low<=high){
            int middle=(low+high)/2;
//            如果是公共前缀，去middle后面找
            if(istrue(strs,middle)){
                low=middle+1;
//                不是，去middle前面找
            }else {
                high=middle-1;
            }
        }
        return strs[0].substring(0,(low+high)/2);
    }
//    判断0-middle部分是否为公共前缀
    public static boolean istrue(String[] strs,int middle){
//        随便拿一个数的 0-middle
        String tar = strs[0].substring(0, middle);
//        遍历判断
        for(String s:strs){
            if(!s.startsWith(tar))return false;
        }
        return true;
    }


        public static void main(String[] args) {
        a14_longestCommonPrefix a14 = new a14_longestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println(a14.longestCommonPrefix2(strs));
    }
}
