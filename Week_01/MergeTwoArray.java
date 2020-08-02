/**
 * @Auther: Lance.Lu
 * @Date: 2020/8/2 17:49
 * @Description:
 */
public class MergeTwoArray {
    //开辟新数组，空间复杂度稍高。
//        public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int j = 0, k = 0, r = 0;;
//        int[] arr = new int[m + n];
//        while (r < arr.length) {
//            if (nums1[j] < nums2[k] && j < m) {
//                arr[r++] = nums1[j++];
//            } else {
//                arr[r++] = nums2[k++];
//            }
//        }
//        nums1 = arr;
//        for (int i = 0; i < nums1.length; i++) {
//            System.out.println(nums1[i]);
//        }
//    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 用三个指针记录
        int j = m - 1, k = n - 1, r = m + n - 1;
        while (r >= 0) {
            // 表示num1数组已经全部移完
            if (j < 0 && k >= 0) {
                nums1[r--] = nums2[k--];
            } else if (k < 0 && j >= 0) {
                // 表示nums2数组已经全部移完
                nums1[r--] = nums1[j--];
            } else {
                // 都没移完则比较大小
                nums1[r--] = nums1[j] > nums2[k] ? nums1[j--] : nums2[k--];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        MergeTwoArray mergeTwoArray = new MergeTwoArray();
        mergeTwoArray.merge(nums1, 3, nums2, 3);
    }
}
