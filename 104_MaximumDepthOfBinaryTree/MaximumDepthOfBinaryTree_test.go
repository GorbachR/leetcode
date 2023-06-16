package MaximumDepthOfBinaryTree

import (
	"math"
	"testing"
)

func TestMaxDepth(t *testing.T) {
	// MinInt = stand In for nil
	bin1 := []int{3, 9, 20, math.MinInt, math.MinInt, 15, 7}
	root1 := BinTreeConstruction(bin1)

	result1, expected1 := maxDepth(root1), 3

	if result1 != expected1 {
		t.Errorf("Test 1 failed, expected %v but got %v", expected1, result1)
	}

	bin2 := []int{1, math.MinInt, 2}
	root2 := BinTreeConstruction(bin2)

	result2, expected2 := maxDepth(root2), 2

	if result2 != expected2 {
		t.Errorf("Test 2 failed, expected %v but got %v", expected2, result2)
	}
}

func BinTreeConstruction(nums []int) *TreeNode {
	return buildTree(nums, 0)
}

func buildTree(nums []int, index int) *TreeNode {

	if index >= len(nums) {
		return nil
	}
	node := &TreeNode{Val: nums[index]}

	node.Left = buildTree(nums, 2*index+1)
	node.Right = buildTree(nums, 2*index+2)

	return node
}
