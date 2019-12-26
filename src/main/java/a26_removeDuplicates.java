public class a26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)return 0;
        int max = nums[0];
        int number = 1;
        for(int i=1;i<nums.length;i++){
            if(max<nums[i]){
                nums[number]=nums[i];
                max=nums[i];
                number++;
            }
        }
        return number;
    }

//      没必要再用max记录，因为a[number]就是max了
    public int removeDuplicates2(int[] nums) {
        if(nums.length==0)return 0;
        int number = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[number]!=nums[i]){
                number++;
                nums[number]=nums[i];
            }
        }
        return number+1;
    }

    public static void main(String[] args) {
        a26_removeDuplicates a26 = new a26_removeDuplicates();
        int[] nums = {0,0,1,1,2,2,3,3,4};
        a26.removeDuplicates2(nums);
    }
}
