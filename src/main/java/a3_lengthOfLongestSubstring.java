import java.util.HashMap;
import java.util.Map;

//找出不重复字符的最长字串长度
//        输入: "abcabcbb"
//        输出: 3
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//    （这个字串同一字母只能有一个）

public class a3_lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
//        int max = 0,count = 0;
//        String[] split = s.split("");
//        Map map = new HashMap<String,String>();
//        for(int i=0;i<s.length();i++){
//            String ch = split[i];
//            if(!map.containsKey(ch)){
//                map.put(ch,i);
//                count++;
//            }else{
//                Integer integer = (Integer)map.get(ch);
//                map.clear();
//                i = integer;
//                if(count>max)max=count;
//                count=0;
//            }
//        }
//        if(count>max)max=count;
//        return max;

        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character,Integer>();
//        i是记录无重复字串的开头，j是结尾，所以j++
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
//                如果遍历到重复字母，找出上一个重复字母位置（max是防止倒退到比记录开头位置更前的地方，既多个重复字母的情况）
                i = Math.max(map.get(s.charAt(j)), i);
            }
//            比较原有ij最长长度 和 以旧重复字母开头为i 当前j的长度
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int num = lengthOfLongestSubstring("abcdazxcvmn");
        System.out.println(num);
    }
}
