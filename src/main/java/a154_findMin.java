public class a154_findMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right])
                right = mid;
            else if (nums[mid] > nums[right])
                left = mid+1;
//            与上题比，多了相同部分，去掉了自己相同的部分，对找出最小没有影响
            else if (nums[right] == nums[mid])
                right--;
        }
        return nums[left];
    }
    public static void main(String[] args) {
        a154_findMin a154 = new a154_findMin();
        int nums[] = {3,1,1};
        System.out.println(a154.findMin(nums));
    }
}
