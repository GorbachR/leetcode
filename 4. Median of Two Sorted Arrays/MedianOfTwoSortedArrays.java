
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(
                solution.findMedianSortedArrays(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                        new int[] { 12, 15, 18, 20, 40 }));
    }

}

// This one was rough I'm ngl
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return getMedian(nums2);

        if (nums2.length == 0)
            return getMedian(nums1);

        return nums1.length > nums2.length ? getMedianIndex(nums2, nums1, 0, nums2.length)
                : getMedianIndex(nums1, nums2, 0, nums1.length);
    }

    private double getMedian(int[] input) {
        return input.length % 2 != 0 ? input[input.length / 2]
                : (double) (input[input.length / 2] + input[input.length / 2 - 1]) / 2;
    }

    private double getMedianIndex(int[] nums1, int[] nums2, int start, int end) {

        int part1 = (start + end) / 2;
        int part2 = (nums1.length + nums2.length + 1) / 2 - part1;

        int num1x = part1 == 0 ? Integer.MIN_VALUE : nums1[part1 - 1];
        int num1y = part1 == nums1.length ? Integer.MAX_VALUE : nums1[part1];
        int num2x = part2 == 0 ? Integer.MIN_VALUE : nums2[part2 - 1];
        int num2y = part2 == nums2.length ? Integer.MAX_VALUE : nums2[part2];

        if (num1x <= num2y && num2x <= num1y)
            return (nums1.length + nums2.length) % 2 != 0 ? Math.max(num1x, num2x)
                    : ((double) (Math.max(num1x, num2x) + (double) Math.min(num1y, num2y)) / 2);

        if (num1x > num2y)
            return getMedianIndex(nums1, nums2, start, part1 - 1);
        else
            return getMedianIndex(nums1, nums2, part1 + 1, end);
    }
}
