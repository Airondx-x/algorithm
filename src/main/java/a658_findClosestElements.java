import java.util.ArrayList;
import java.util.List;

public class a658_findClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;
//      0到size-k 是小区间 第一个数会存在的区域，在这里收缩
        int left = 0;
        int right = size - k;

        while (left < right) {
            int mid = (left + right) >>> 1;
//            关键点：因为找的是小区间开头，当开头数比结尾数距离x还要远的时候，说明要往右移
//            因为实质是判断k长度的头尾数什么时候离x最短，所以不断比较头尾和x距离来收缩这个开头数的位置
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

//    双指针
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-1;
        while(right-left>=k){
            if(x-arr[left]>arr[right]-x){
                left++;
            }else{
                right--;
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        a658_findClosestElements a658 = new a658_findClosestElements();
        int[] arr = {1,2,3,4,5,6,7};int k = 3;int x =5;
        List<Integer> res = a658.findClosestElements(arr, k, x);
        for (int i:res) {
            System.out.print(i+" ");
        }
    }
}
