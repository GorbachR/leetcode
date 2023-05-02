function search(
  nums: number[],
  target: number,
  leftLimit: number = 0,
  rightLimit: number = nums.length - 1
): number {
  if (rightLimit < leftLimit) return -1;

  const centerPos = Math.trunc(leftLimit + (rightLimit - leftLimit) / 2);

  // console.log(leftLimit, rightLimit);

  if (nums[centerPos] === target) return centerPos;

  if (
    (nums[centerPos] > target &&
      !(nums[rightLimit] < nums[centerPos] && nums[rightLimit] >= target)) ||
    (nums[centerPos] < target &&
      nums[leftLimit] > nums[centerPos] &&
      nums[leftLimit] <= target)
  )
    return search(nums, target, leftLimit, centerPos - 1);
  else return search(nums, target, centerPos + 1, rightLimit);
}

// console.log(search([1, 3], 3));
console.log(search([4, 5, 6, 7, 0, 1, 2], 0));
console.log(search([4, 5, 6, 7, 8, 1, 2, 3], 8));
