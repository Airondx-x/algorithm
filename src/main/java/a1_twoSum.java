import java.util.*;
//数组中找到两数和为目标值的下标
//输入：nums = [2, 7, 11, 15], target = 9
//        输出：[0, 1]

public class a1_twoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] ints = twoSum2(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
//        两次遍历
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int jian = target - nums[i];
            if (map.containsKey(jian) && map.get(jian) != i) {
                return new int[]{i, map.get(jian)};
            }
        }
        throw new IllegalArgumentException("XXX");
    }

    public static int[] twoSum2(int[] nums, int target) {
//        一次遍历
//        不用再判断符合的数是否自身，也因为判断的时候一直是自身，所以判断完再put
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int jian = target - nums[i];
            if (map.containsKey(jian)) {
                return new int[]{map.get(jian),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("XXX");
    }
}

