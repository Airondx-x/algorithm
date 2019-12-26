public class a287_findDuplicate {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
//        要详细看题意，n+1个数所有数都在1到n中
        int left = 1;
        int right = len - 1;
        while (left < right) {
//            算出中位数
            int mid = (left + right) >>> 1;
            int counter = 0;
//            遍历整个数组，计算比中位数小的个数(包括自身)
            for (int num : nums) {
                if (num <= mid) {
                    counter += 1;
                }
            }
//            这里很关键,因为他是返回下标作为结果的
//            如果数量大于中位数,例如:1 2 5 3 3...,中位数是4,有4个数是符合的,证明重复的数是小于中位数4的
            if (counter > mid) {
                right = mid;
            } else {
//                重复数大于中位数
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        a287_findDuplicate a287 = new a287_findDuplicate();
        int[] nums = {3,1,3,4,2};
        System.out.println(a287.findDuplicate(nums));
    }
}
