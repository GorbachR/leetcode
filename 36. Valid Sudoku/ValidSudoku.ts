function isValidSudoku(board: string[][]): boolean {
  let x = 0;
  let y = 0;

  const rowMemo: Set<string>[] = [];
  const colMemo: Set<string>[] = [];
  const boxMemo: Set<string>[] = [];

  for (let i = 0; i < 9; i++) {
    rowMemo.push(new Set<string>());
    colMemo.push(new Set<string>());
    boxMemo.push(new Set<string>());
  }

  for (let row = 0; row < board.length; row++) {
    for (let col = 0; col < board[row].length; col++) {
      if (board[row][col] === ".") continue;

      const currentVal = board[row][col];
      const boxPos = Math.trunc(row / 3) * 3 + Math.trunc(col / 3);

      if (
        rowMemo[row].has(currentVal) ||
        colMemo[col].has(currentVal) ||
        boxMemo[boxPos].has(currentVal)
      )
        return false;

      rowMemo[row].add(currentVal);
      colMemo[col].add(currentVal);
      boxMemo[boxPos].add(currentVal);
    }
  }

  return true;
}

console.log(
  isValidSudoku([
    ["5", "3", ".", ".", "7", ".", ".", ".", "."],
    ["6", ".", ".", "1", "9", "5", ".", ".", "."],
    [".", "9", "8", ".", ".", ".", ".", "6", "."],
    ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
    ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
    ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
    [".", "6", ".", ".", ".", ".", "2", "8", "."],
    [".", ".", ".", "4", "1", "9", ".", ".", "5"],
    [".", ".", ".", ".", "8", ".", ".", "7", "9"],
  ])
);
