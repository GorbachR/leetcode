import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.twoSum(new int[] { 2, 7, 11, 15 }, 9));

    }
}

// Naive n^2 solution
class Solution {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }

        return nums;
    }
}

class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] solution = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int neededValue = target - nums[i];
            Integer secondValue = map.get(neededValue);

            if (secondValue != null) {
                solution[0] = i;
                solution[1] = secondValue;
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return solution;
    }
}
