//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
//找出 nums 中的三个整数，使得它们的和与 target 最接近。
//返回这三个数的和。
//输入： nums = [-1，2，1，-4], 和 target = 1.
//输出： 与 target 最接近的三个数的和为 2
import java.util.Arrays;

public class a16_threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int res = 0;
//        排序
        Arrays.sort(nums);
//        nums[i]是三数中的第一个（我也不知道为什么是第二个这么难）
        for(int i=0;i< nums.length-1;i++){
            int left=i+1,right=nums.length-1;
//            除了开头，如果重复就可以跳过
            if(i>0&&nums[i]==nums[i-1])continue;
            while(left<right){
                int sum=nums[left]+nums[right]+nums[i];
                if(min==0)break;
                else if(Math.abs(sum-target)<min){
                    min=Math.abs(sum-target);
                    res = sum;
//                    结果比预期大  最大的数变小
                }else if(sum>target){
                    right--;
//                    结果比预期小  最小的数变大
                }else if(sum<target){
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        a16_threeSumClosest a16 = new a16_threeSumClosest();
        int[] nums = {-1,-2,-1,0};
        int i = a16.threeSumClosest(nums, -4);
            System.out.println(i);
    }
}

