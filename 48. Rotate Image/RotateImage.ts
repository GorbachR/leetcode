function rotate(matrix: number[][]): void {
  let memo = 0;

  let startPos = 0;
  // transpose
  for (let i = 0; i < matrix.length; i++) {
    for (let j = i; j < matrix[i].length; j++) {
      memo = matrix[i][j];
      matrix[i][j] = matrix[j][i];
      matrix[j][i] = memo;
    }
  }

  // reverse
  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0, k = matrix[i].length - 1; j < k; j++, k--) {
      memo = matrix[i][j];
      matrix[i][j] = matrix[i][k];
      matrix[i][k] = memo;
    }
  }
}

// faster solution
function rotate2(matrix: number[][]): void {
  const n = matrix.length - 1;

  for (let i = 0; i < Math.trunc((n + 2) / 2); i++) {
    for (let j = 0; j < Math.trunc((n + 1) / 2); j++) {
      const memo = matrix[n - j][i];
      matrix[n - j][i] = matrix[n - i][n - j];
      matrix[n - i][n - j] = matrix[j][n - i];
      matrix[j][n - i] = matrix[i][j];

      matrix[i][j] = memo;
    }
  }
}

const matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

const matrix2 = [
  [5, 1, 9, 11],
  [2, 4, 8, 10],
  [13, 3, 6, 7],
  [15, 14, 12, 16],
];

console.log(matrix2);
rotate2(matrix2);
console.log(matrix2);
