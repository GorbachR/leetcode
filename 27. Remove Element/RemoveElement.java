public class RemoveElement {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeElement(new int[] { 3, 2, 2, 3 }, 3));
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}