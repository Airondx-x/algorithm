//一个升序数组，但一段会旋转
//例如0，1，2，4，5，6，7   旋转后：4，5，6，7，0，1，2
//然后O（logn）时间内返回元素下标
public class a33_search {

    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start<=end){
            mid = (start+end)/2;
            if(nums[mid]==target)
                return mid;
//            前半部分有序
            if (nums[start] <= nums[mid]) {
                if(nums[start]<=target&&target<nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
//              后半部分有序
            }else{
                if(nums[mid]<target&&target<=nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        a33_search a33 = new a33_search();
        int nums[] = {4,5,6,7,0,1,2};
        System.out.println(a33.search(nums,0));
    }
}
