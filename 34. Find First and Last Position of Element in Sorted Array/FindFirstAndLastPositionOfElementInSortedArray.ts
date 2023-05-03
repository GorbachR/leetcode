function searchRange(nums: number[], target: number): number[] {
  return [findFirst(nums, target), findLast(nums, target)];
}

function findFirst(
  nums: number[],
  target: number,
  leftLimit: number = 0,
  rightLimit: number = nums.length - 1
): number {
  if (leftLimit <= rightLimit) {
    const centerPos = Math.trunc(leftLimit + (rightLimit - leftLimit) / 2);

    if (
      (centerPos === 0 || nums[centerPos - 1] < target) &&
      nums[centerPos] === target
    )
      return centerPos;

    if (nums[centerPos] < target)
      return findFirst(nums, target, centerPos + 1, rightLimit);
    else return findFirst(nums, target, leftLimit, centerPos - 1);
  }
  return -1;
}

function findLast(
  nums: number[],
  target: number,
  leftLimit: number = 0,
  rightLimit: number = nums.length - 1
): number {
  if (leftLimit <= rightLimit) {
    const centerPos = Math.trunc(leftLimit + (rightLimit - leftLimit) / 2);

    if (
      (centerPos === nums.length - 1 || nums[centerPos + 1] > target) &&
      nums[centerPos] === target
    )
      return centerPos;

    if (nums[centerPos] > target)
      return findLast(nums, target, leftLimit, centerPos - 1);
    else return findLast(nums, target, centerPos + 1, rightLimit);
  }
  return -1;
}

console.log(searchRange([5, 7, 7, 8, 8, 10], 8));
