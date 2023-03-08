import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(new int[] { 1, 1, 1, 0 }, 100));
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestValue = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j != k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(target - closestValue) > Math.abs(target - sum))
                    closestValue = sum;

                if (target - sum > 0)
                    j++;
                else
                    k--;
            }
        }

        return closestValue;
    }
}