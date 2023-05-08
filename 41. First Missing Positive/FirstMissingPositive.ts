function firstMissingPositive(nums: number[]): number {
  for (let i = 0; i < nums.length; i++) {
    const roundedVal = Math.round(nums[i]);

    if (roundedVal >= 1 && roundedVal <= nums.length) {
      nums[roundedVal - 1] = nums[roundedVal - 1] + 0.0001;
    } else nums[i] = nums.length + 1 + (nums[i] % 1);
  }

  for (let i = 0; i < nums.length; i++) {
    if (nums[i] % 1 === 0) return i + 1;
  }

  return nums.length + 1;
}

console.log(firstMissingPositive([3, 4, -1, 1]));
