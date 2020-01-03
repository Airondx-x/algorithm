public class a53_maxSubArray {
//    贪心算法O(n)
    public int maxSubArray2(int[] nums) {
        int currsum =nums[0];
        int maxsum = nums[0];
        for(int i=1;i<nums.length;i++){
            currsum=Math.max(nums[i],currsum+nums[i]);
            maxsum = Math.max(currsum,maxsum);
        }
        return maxsum;
    }

//    动态规划O(n)
    public int maxSubArray1(int[] nums) {
        int maxsum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>0)nums[i]+=nums[i-1];
            maxsum = Math.max(nums[i],maxsum);
        }
        return maxsum;
    }

//    分治法O(Nlogn)
////////////////////////////////////////////
/*    分三种情况：
      1、最大字串完全出现在左边
      2、最大字串完全出现在右边边
      1、最大字串出现在中间，横跨左右
*/
    public int maxSubArray3(int[] nums) {
         return helper(nums,0,nums.length-1);
    }

    public int helper(int[] nums,int left,int right){
        if(left==right)return nums[left];
        int mid = (left+right)>>1;
//        算出情况1最大的值
        int leftsum = helper(nums,left,mid);
//        算出情况2最大的值
        int rightsum = helper(nums,mid+1,right);
//        算出情况3最大的值
        int crosssum = crosssum(nums,left,right,mid);

//        比较
        return Math.max(crosssum,Math.max(leftsum,rightsum));
    }

    public int crosssum(int[] nums,int left,int right,int mid){
        if(left==right)
            return nums[left];
        int leftsum=Integer.MIN_VALUE,rightsum=Integer.MIN_VALUE;
        int currsum = 0;
//        把整个左边都遍历完，每加一个数就判断一次是否最大值能更新
        for(int i=mid;i>=left;i--){
            currsum += nums[i];
            leftsum = Math.max(leftsum,currsum);
        }
//        把整个右边都遍历完，每加一个数就判断一次是否最大值能更新
        currsum = 0;
        for(int i=mid+1;i<=right;i++){
            currsum += nums[i];
            rightsum = Math.max(rightsum,currsum);
        }

        return leftsum+rightsum;
    }


////////////////////////////////////////////
    public static void main(String[] args) {
        a53_maxSubArray a53 = new a53_maxSubArray();
        int[] nums = {-1,-2};
        int i = a53.maxSubArray3(nums);
        System.out.println(i);
    }
}
