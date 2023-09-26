function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  for (let i = m + n - 1, j = m - 1, k = n - 1; i >= 0; i--) {
    if (j < 0 || nums2[k] > nums1[j]) {
      nums1[i] = nums2[k];
      k--;
    } else {
      nums1[i] = nums1[j];
      j--;
    }
  }
}

const arr1 = [1, 2, 3, 0, 0, 0];
merge(arr1, 3, [2, 5, 6], 3);
console.log(arr1);

const arr2 = [4, 5, 6, 0, 0, 0];
merge(arr2, 3, [1, 2, 3], 3);
console.log(arr2);

const arr3 = [4, 0, 0, 0, 0, 0];
merge(arr3, 1, [1, 2, 3, 5, 6], 5);
console.log(arr3);
