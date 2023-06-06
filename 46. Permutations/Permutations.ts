function permute(nums: number[]): number[][] {
  if (nums.length === 1) return [[nums[0]]];

  const prevVals = permute(nums.slice(1));
  const withCurrentVal: number[][] = [];

  for (let i = 0; i < prevVals.length; i++) {
    for (let j = 0; j <= prevVals[i].length; j++) {
      withCurrentVal.push([
        ...prevVals[i].slice(0, j),
        nums[0],
        ...prevVals[i].slice(j),
      ]);
    }
  }

  return withCurrentVal;
}

console.log(permute([1, 2, 3]));
