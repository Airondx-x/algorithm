public class a27_removeElement {

    public int removeElement(int[] nums, int val) {
        int number = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[number] = nums[i];
                number++;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        a27_removeElement a27 = new a27_removeElement();
        int[]nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        a27.removeElement(nums,val);
    }
}
