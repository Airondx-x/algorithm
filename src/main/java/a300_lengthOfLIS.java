public class a300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
//        res记录j有没有变化，有变化说明这个num在tails中的前部分，不是升序的，
//        没有变化说明这个num比tail中全部都大，num已经加进了tails中，所以下次循环中j要++包括新的num，更新了right
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }



    public static void main(String[] args) {
        a300_lengthOfLIS a300 = new a300_lengthOfLIS();
        int nums[] = {1,3,6,7,9,4,10,5,6};
        System.out.println(a300.lengthOfLIS(nums));
    }
}
