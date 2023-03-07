public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }
}

// Naive n^2 solution
class Solution {
    public int maxArea(int[] height) {

        int maxValue = 0;

        for (int i = 0; i < height.length; i++) {
            int currentValue;

            for (int j = i + 1; j < height.length; j++) {
                currentValue = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
                if (currentValue > maxValue)
                    maxValue = currentValue;
            }
        }
        return maxValue;
    }
}

class Solution2 {
    public int maxArea(int[] height) {

        int maxValue = 0;
        int i = 0;
        int j = height.length - 1;
        while (j != i) {
            int currentValue = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
            if (currentValue > maxValue)
                maxValue = currentValue;

            if (height[i] > height[j])
                j--;
            else
                i++;
        }
        return maxValue;
    }
}