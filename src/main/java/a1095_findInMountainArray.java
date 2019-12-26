public class a1095_findInMountainArray {
//    public int findInMountainArray(int target,int[] mountainArr) {
//        int left = 0;
//        int right = mountainArr.length-1;
//        int resl=-1;
//        int resr=-1;
//        if(mountainArr.length==1){
//            return mountainArr[0]==target?0:-1;
//        }
//        while(left<right) {
//            int mid = (left + right) >>> 1;
//            if (mountainArr[mid] < mountainArr[mid+1]) {
//                if (mountainArr[mid] > target) {
//                    right = mid;
//                } else {
//                    left = mid + 1;
//                }
//            }else {
//                right = mid;
//            }
//        }
//        if(mountainArr[left] == target) {
//            resl = left;
//        }
//
//        left = 0;
//        right = mountainArr.length-1;
//        while(left<right){
//            int mid = (left + right) >>> 1;
//            if(mountainArr[mid]>mountainArr[mid+1]){
//                if (mountainArr[mid]>target){
//                    left = mid+1;
//                }else{
//                    right = mid;
//                }
//            }else{
//                left = mid + 1 ;
//            }
//        }
//        if(mountainArr[left] == target) {
//            resr = left;
//        }
//        if(resl==-1||resr==-1)
//            return Math.max(resl,resr);
//        else
//            return Math.min(resl,resr);
//    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        // 步骤 1：先找到山顶元素所在的索引
        int mountaintop = findMountaintop(mountainArr, 0, size - 1);
        // 步骤 2：在前有序且升序数组中找 target 所在的索引
        int res = findFromSortedArr(mountainArr, 0, mountaintop, target);
        if (res != -1) {
            return res;
        }
        // 步骤 3：如果步骤 2 找不到，就在后有序且降序数组中找 target 所在的索引
        return findFromInversedArr(mountainArr, mountaintop + 1, size - 1, target);
    }

    private int findMountaintop(MountainArray mountainArr, int l, int r) {
        // 返回山顶元素
        while (l < r) {
            int mid = (l + r)>>>1;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // 如果当前的数比右边的数小，它一定不是山顶
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 根据题意，山顶元素一定存在，因此退出 while 循环的时候，不用再单独作判断
        return l;
    }
    private int findFromSortedArr(MountainArray mountainArr, int l, int r, int target) {
        // 在前有序且升序数组中找 target 所在的索引
        while (l < r) {
            int mid = (l + r)>>>1;
            if (mountainArr.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 因为不确定区间收缩成 1个数以后，这个数是不是要找的数，可能不存在,因此单独做一次判断
        if (mountainArr.get(l) == target) {
            return l;
        }
        return -1;
    }

    private int findFromInversedArr(MountainArray mountainArr, int l, int r, int target) {
        // 在后有序且降序数组中找 target 所在的索引
        while (l < r) {
            int mid = (l + r)>>>1;
            // 与 findFromSortedArr 方法不同的地方仅仅在于由原来的小于号改成大于好
            if (mountainArr.get(mid) > target) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        // 因为不确定区间收缩成 1个数以后，这个数是不是要找的数，因此单独做一次判断
        if (mountainArr.get(l) == target) {
            return l;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 3,2,1};
        int target = 1;
        MountainArray mountainArray = new MountainArrayImpl(arr);
        a1095_findInMountainArray a1095 = new a1095_findInMountainArray();
        System.out.println(a1095.findInMountainArray(target,mountainArray));
    }
}



interface MountainArray {
    public int get(int index);

    public int length();
}


class MountainArrayImpl implements MountainArray {
    private int[] arr;
    private int size;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
        this.size = this.arr.length;
    }

    @Override
    public int get(int index) {
        return this.arr[index];
    }

    @Override
    public int length() {
        return this.size;
    }

}
