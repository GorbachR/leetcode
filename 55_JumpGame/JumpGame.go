package JumpGame

func canJump(nums []int) bool {

	for maxJump, i := 0, 0; i < len(nums); i++ {

		if i > maxJump {
			return false
		}

		maxJump = max(maxJump, i+nums[i])
	}

	return true
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
