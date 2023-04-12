public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2 };
        Solution s = new Solution();
        s.nextPermutation(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}

class Solution {
    public void nextPermutation(int[] nums) {

        int leftSwapInd = -1;
        int rightSwapInd = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                leftSwapInd = i;
                break;
            }
        }

        if (leftSwapInd == -1) {
            reverseArr(nums, 0);
            return;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[leftSwapInd]) {
                rightSwapInd = i;
                break;
            }
        }

        int memo = nums[leftSwapInd];
        nums[leftSwapInd] = nums[rightSwapInd];
        nums[rightSwapInd] = memo;

        reverseArr(nums, leftSwapInd + 1);
    }

    private void reverseArr(int[] nums, int from) {
        int memo = 0;
        for (int i = from, j = nums.length - 1; i < j; i++, j--) {
            memo = nums[i];
            nums[i] = nums[j];
            nums[j] = memo;
        }
    }
}