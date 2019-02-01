package L0004MedianofTwoSortedArrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // make sure m <=n
        if (m > n) {
            int[] tmpNums = nums1;
            nums1 = nums2;
            nums2 = tmpNums;
            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMax + iMin) / 2;
            int halfLen = (n + m + 1) /2;
            int j = halfLen - i;

            // i is too small
            if (i < iMax && nums2[j-1] > nums1[i]) {
                iMin = i + 1;
            }
            // i is too big
            else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            }
            else {
                int leftMax = 0;
                if (i == 0) {
                    leftMax = nums2[j-1];
                } else if (j == 0) {
                    leftMax = nums1[i-1];
                } else {
                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
                }
                // odd length
                if ((m + n) % 2 == 1) {
                    return leftMax;
                }
                // even length
                int rightMin = 0;
                if (i == m) {
                    rightMin = nums2[j];
                } else if (j == n) {
                    rightMin = nums1[i];
                } else {
                    rightMin = Math.min(nums1[i], nums2[j]);
                }
                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,3};
        int[] nums2 = new int[] {2};
        Solution test = new Solution();
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }
}
