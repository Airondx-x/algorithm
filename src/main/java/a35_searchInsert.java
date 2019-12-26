//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
// 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

public class a35_searchInsert {
    public int searchInsert(int[] nums, int target) {
//         二分法
        if (nums.length == 0)
            return -1;
        if (nums[nums.length - 1] < target)
            return nums.length;
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        a35_searchInsert a35 = new a35_searchInsert();
        int[] nums = {1,3,5,6};
        int i = a35.searchInsert(nums, 7);
        System.out.println(i);

    }
}
