package JumpGame

func canJump(nums []int) bool {

	for maxJump, i := 0, 0; i < len(nums); i++ {

		if i > maxJump {
			return false
		}

		maxJump = max(maxJump, i+nums[i])

		if maxJump >= len(nums)-1 {
			return true
		}
	}

	return false
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
