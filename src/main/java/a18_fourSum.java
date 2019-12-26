import java.util.*;

//给定一个包含 n 个整数的数组 nums 和一个目标值 target，
//判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
//找出所有满足条件且不重复的四元组。
//给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//        满足要求的四元组集合为：
//        [
//        [-1,  0, 0, 1],
//        [-2, -1, 1, 2],
//        [-2,  0, 0, 2]
//        ]

public class a18_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
//        排序
        Arrays.sort(nums);
        for(int i=0;i< nums.length-3;i++) {
//            这个地方可以直接判定i不能和上一个重复，
            if(i>0&&nums[i]==nums[i-1])continue;
//            优化剪枝
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) continue;

            for (int j = i + 1; j < nums.length-2; j++) {
                int left = j + 1, right = nums.length - 1;
//                这个地方不能像i一样，要多一个判断，因为ij相邻时是允许ij重复的
                if(j>0&&j-1!=i&&nums[j]==nums[j-1])continue;

//                优化剪枝
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) continue;

                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i],nums[j], nums[left], nums[right]));
//                    跳过了剩下两指针缩短的区域内有相同结果nums[left]和nums[right]的情况
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
//                    找下一三数
                        left++;
                        right--;
//                    结果比预期大  最大的数变小
                    } else if (sum > target) {
                        right--;
//                    结果比预期小  最小的数变大
                    } else if (sum < target) {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        a18_fourSum a18 = new a18_fourSum();
        int[] nums= {-1,0,-5,-2,-2,-4,0,1,-2};
        List<List<Integer>> lists = a18.fourSum(nums,-9);
        for (List<Integer> l:lists) {
            System.out.print(l);
        }
    }
}
