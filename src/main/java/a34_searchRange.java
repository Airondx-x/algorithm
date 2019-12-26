public class a34_searchRange {

//    public int[] searchRange(int[] nums, int target) {
//        int res[] = {-1,-1};
//        int start = 0;
//        int end = nums.length-1;
//        int mid ;
//        while(start<=end){
//            mid = (start+end)/2;
//            if(res[0]==-1) {
//                if (nums[mid] == target) {
//                    if ((mid - 1 >= 0 && nums[mid - 1] != target) || mid == 0||mid == nums.length-1) {
//                        res[0] = mid;
//                        end = nums.length-1;
//                    } else {
//                        end = mid - 1;
//                    }
//                } else if (nums[mid] > target) {
//                    end = mid - 1;
//                } else if (nums[mid] < target) {
//                    start = mid + 1;
//                }
//            }
//
//            if(res[0]!=-1){
//                mid = (start+end)/2;
//                if(nums[mid]==target) {
//                    if ((mid + 1 <= nums.length - 1 && nums[mid + 1] != target) || mid == nums.length - 1) {
//                        res[1] = mid;
//                        break;
//                    } else {
//                        start = mid + 1;
//                    }
//                }else{
//                    end = mid - 1;
//                }
//            }
//        }
//        return res;
//    }



    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
//        找出下标
        int leftIdx = extremeInsertionIndex(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
//            一个方法内能让左右下标都可以循环，所以统一返回lo；
//            都是不断的往左边区域缩小，只不过左下标遇到target也会缩小，所以排除了后面的target
//            右下标不会缩小target，所以最终结果就是target后的下一个位置
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        a34_searchRange a34 = new a34_searchRange();
        int[] nums = {5,6,7,7,7,8,9}; int target = 7;
        int[] ints = a34.searchRange(nums, target);
        for (int a:ints) {
            System.out.print(a+" ");
        }
    }
}
