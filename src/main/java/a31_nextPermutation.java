//左输入→右输出
//1,2,3 → 1,3,2
//1,1,5 → 1,5,1
//3,2,1 → 1,2,3

public class a31_nextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
//        从最后开始找到不是降序的两个数就跳出循环
        while (i>=0&&nums[i+1]<=nums[i]){
            i--;
        }
//        如果存在
        if(i>=0){
            int j=nums.length-1;
//            循环往前直到找到一个比 上面数i大的数j
            while (j>=0&&nums[j]<=nums[i]){
                j--;
            }
//            交换这个两个数，之后后半段的数是完全降序的
            swap(nums,i,j);
        }
//        因为要找出下一个大的数，所以应该是完全升序才是最小的比当前大一个的数
//        并且如果不存在这个i，就说明这个数是最大的，刚好把它完全逆序就是题目的结果
        reverse(nums,i+1);
    }

    public void reverse(int[] nums,int i){
        int j = nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        a31_nextPermutation a31 = new a31_nextPermutation();
        int[] nums = {3,4,2,1};
        a31.nextPermutation(nums);
    }
}
