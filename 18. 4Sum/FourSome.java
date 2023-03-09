import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSome {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.fourSum(new int[] { 1, -2, -5, -4, -3, 3, 3, 5 }, -11));
    }
}

// Could be optimized, kinda messy
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> combination = new ArrayList<>();

        for (int a = 0; a < nums.length - 3; a++) {

            if (a > 0 && nums[a] == nums[a - 1])
                continue;

            for (int b = a + 1; b < nums.length - 2; b++) {
                int c = b + 1;
                int d = nums.length - 1;

                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;

                while (c != d) {

                    if (c > b + 1 && nums[c] == nums[c - 1]) {
                        c++;
                        continue;
                    }

                    int sum = 0;

                    try {
                        int sumAB = Math.addExact(nums[a], nums[b]);
                        int sumABC = Math.addExact(sumAB, nums[c]);
                        sum = Math.addExact(sumABC, nums[d]);
                    } catch (Exception e) {
                        c++;
                        continue;
                    }

                    if (sum == target) {
                        combination.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                    }

                    if (sum > target)
                        d--;
                    else
                        c++;
                }
            }
        }

        return combination;
    }
}