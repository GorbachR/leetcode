package JumpGame

import "testing"

func TestCanJumpU(t *testing.T) {
	input1 := []int{2, 3, 1, 1, 4}

	result1, expected1 := canJump(input1), true

	if result1 != expected1 {
		t.Errorf("Test1 failed, expected %t but got %t", expected1, result1)
	}

	input2 := []int{3, 2, 1, 0, 4}

	result2, expected2 := canJump(input2), false

	if result2 != expected2 {
		t.Errorf("Test2 failed, expected %t but got %t", expected2, result2)
	}
}
