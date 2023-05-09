type MaxHeight = {
  left: number;
  right: number;
};

function trap(height: number[]): number {
  const maxHeight: MaxHeight[] = new Array(height.length);

  for (let i = 0; i < maxHeight.length; i++)
    maxHeight[i] = { left: 0, right: 0 };

  let rainTrapped = 0;

  for (let l = 1, highestVal = height[0]; l < height.length; l++) {
    maxHeight[l].left = highestVal;
    if (highestVal < height[l]) highestVal = height[l];
  }

  for (
    let r = height.length - 2, highestVal = height[height.length - 1];
    r >= 0;
    r--
  ) {
    maxHeight[r].right = highestVal;
    if (highestVal < height[r]) highestVal = height[r];
  }

  for (let i = 0; i < maxHeight.length; i++) {
    if (maxHeight[i].left > height[i] && maxHeight[i].right > height[i])
      rainTrapped +=
        Math.min(maxHeight[i].left, maxHeight[i].right) - height[i];
  }

  return rainTrapped;
}

// more efficient 2 pointer solution runtime O(n), space O(1)
function trap2(height: number[]): number {
  let rainTrapped = 0;
  let l = 1;
  let r = height.length - 2;
  let leftMax = height[0];
  let rightMax = height[height.length - 1];

  while (r >= l) {
    if (leftMax < rightMax) {
      if (height[l] >= leftMax) leftMax = height[l];
      else rainTrapped += leftMax - height[l];
      l++;
    } else {
      if (height[r] >= rightMax) rightMax = height[r];
      else rainTrapped += rightMax - height[r];
      r--;
    }
  }

  return rainTrapped;
}

console.log(trap2([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]));
