import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }
}

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        quickSort(nums);

        List<List<Integer>> returnList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > 0)
                break;

            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j != k) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0)
                    returnList.add(Arrays.asList(nums[i], nums[j], nums[k]));

                if (sum > 0)
                    k--;
                else
                    j++;

            }
        }

        return returnList;
    }

    private void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int leftLimit, int rightLimit) {

        if (rightLimit <= leftLimit)
            return;

        int pivot = rightLimit;
        int memo = 0;
        int i = leftLimit - 1;
        int j = leftLimit;

        while (j < pivot) {
            if (nums[j] <= nums[pivot]) {
                i++;
                memo = nums[i];
                nums[i] = nums[j];
                nums[j] = memo;
            }
            j++;
        }

        memo = nums[i + 1];
        nums[i + 1] = nums[pivot];
        nums[pivot] = memo;

        quickSort(nums, leftLimit, i);
        quickSort(nums, i + 2, rightLimit);
    }
}
