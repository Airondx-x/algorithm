
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
//使得 a + b + c = 0 ？
//找出所有满足条件且不重复的三元组。
//输入： nums = [-1, 0, 1, 2, -1, -4]，
//输出：
//        满足要求的三元组集合为：
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]

public class a15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
//        排序
        Arrays.sort(nums);
//        nums[i]是三数中的第一个（我也不知道为什么是第二个这么难）
        for(int i=0;i< nums.length-1;i++){
            int left=i+1,right=nums.length-1;
//            如果最小的数也>0，那后面就不用玩了
            if(nums[i]>0)break;
//            除了开头，如果重复就可以跳过
            if(i>0&&nums[i]==nums[i-1])continue;
            while(left<right){
                int sum=nums[left]+nums[right]+nums[i];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
//                    跳过了剩下两指针缩短的区域内有相同结果nums[left]和nums[right]的情况
                    while (left<right&&nums[left]==nums[left+1])left++;
                    while (left<right&&nums[right]==nums[right-1])right--;
//                    找下一三数
                    left++;
                    right--;
//                    结果比预期大  最大的数变小
                }else if(sum>0){
                    right--;
//                    结果比预期小  最小的数变大
                }else if(sum<0){
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        a15_threeSum a15 = new a15_threeSum();
        int[] nums = {0,0,0};
        List<List<Integer>> lists = a15.threeSum(nums);
        for (List l:lists) {
            System.out.println(l);
        }
    }
}

