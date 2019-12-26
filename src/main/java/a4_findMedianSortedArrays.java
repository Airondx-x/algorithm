
//找出两个有序数组共同的中位数，时间复杂度为O(log(m + n))。
//        nums1 = [1, 3]
//        nums2 = [2]
//        则中位数是 2.0


public class a4_findMedianSortedArrays {

//    思路1：找出第k小的数
    public static double findMedianSortedArrays(int[]nums1,int[]nums2){
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }
    //寻找a 和 b 数组中，第k个数字
    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//        每次递归的两数组长度
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //统一让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
//          len1=0，len1已经被排除空，则直接去len2去找对应位置的数
//        -1对应数组起始位0，也就是第k小是k-1的下标
        if (len1 == 0) return nums2[start2 + k - 1];

//        如果k==1，则找出现在第1小的数，直接比较两数组最小的数
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

//        min防止数组长度小于k/2这种特殊情况
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

//        哪边小，就可以排除小的数组的那前k/2个数，而i+1和j+1就是跳过了k/2个数的下标。
//        nums2小，则相应start变为j+1。
//        因为有  上面minmin防止数组长度小于k/2这种特殊情况   所以递归k的变化也要同上（也就是k变为  k-（排除了的数））
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
//        相反
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }


////    思路2：中位数的思想
    public static double findMedianSortedArrays2(int[]A,int[]B){
                int m = A.length;
        int n = B.length;
        if (m > n) { // 也就是长的是B，下面那个
//            为了方便计算，统一设定m>n，让j能够大于0
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
//            根据i算对应的j
            int j = halfLen - i;
//            要都符合A[i]>B[j-1]和A[i-1]<B[j]，分界线上A左最大的<B右最小的 和 B左最大的<A左最小的
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
//            都符合，找到合适ij位置
//            找出两合集最大值，最小值
            else {
                int maxLeft = 0;
//                i为0：j为m，B全体比A全体小 所以左合集最大是B最大的
                if (i == 0) { maxLeft = B[j-1]; }
//                j为0：i为n，B全体比A全体大 所以左合集最大是A最大的
                else if (j == 0) { maxLeft = A[i-1]; }
//                都不是，AB里面哪个大拿哪个
                else { maxLeft = Math.max(A[i-1], B[j-1]); }


//                如果为奇数个，则选出的就是中位数
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

//                为偶数个的话，就要拿出左最大值，右最小值，求平均
                int minRight = 0;
//                i为m：j为0，A全体比B全体大 所以右合集最小是B最小的
                if (i == m) { minRight = B[j]; }
//                j为n：i为0，A全体比B全体小 所以右合集最小是A最小的
                else if (j == n) { minRight = A[i]; }
//                都不是，拿AB最小的
                else { minRight = Math.min(B[j], A[i]); }
//                  求平均
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int []A={1,2};
        int []B={-1,3};
        double medianSortedArrays = findMedianSortedArrays2(A, B);
        System.out.println(medianSortedArrays);
    }
}
