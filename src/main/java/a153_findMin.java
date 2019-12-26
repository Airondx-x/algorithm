public class a153_findMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < nums[right])
//            如果后半部分是有序的，变化点在left~mid中，但可能mid刚好是变化点，所以保留mid
                right = mid;
            else
//            后半非有序，变化点在mid+1~right中（如果mid是变化点，肯定小于right，所以排除mid）
                left = mid + 1;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        a153_findMin a153 = new a153_findMin();
        int nums[] = {5,1,2,4,6};
        System.out.println(a153.findMin(nums));
    }
}
