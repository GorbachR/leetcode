package NumberOfIslands

import "testing"

func TestNumsIslands(t *testing.T) {
	grid1 := [][]byte{
		{'1', '1', '1', '1', '0'},
		{'1', '1', '0', '1', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '0', '0', '0'}}

	result1, expected1 := numIslands(grid1), 1

	if result1 != expected1 {
		t.Errorf("Test 1 failed, expected %d but got %d", expected1, result1)
	}

	grid2 := [][]byte{
		{'1', '1', '0', '0', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '1', '0', '0'},
		{'0', '0', '0', '1', '1'}}

	result2, expected2 := numIslands(grid2), 3

	if result2 != expected2 {
		t.Errorf("Test 2 failed, expected %d but got %d", expected2, result2)
	}
}
