package RotateArray

// Reverse Swap
func rotate(nums []int, k int) {

	n := len(nums)
	k %= n

	swap(nums, 0, n-1)
	swap(nums, 0, k-1)
	swap(nums, k, n-1)
}

func swap(nums []int, i, j int) {
	for ; i < j; i, j = i+1, j-1 {
		memo := nums[i]
		nums[i] = nums[j]
		nums[j] = memo
	}
}

// Block Swap
func rotate2(nums []int, k int) {

	n := len(nums)
	k %= n

	if k == 0 {
		return
	}

	i, j := n-k, k

	for i != j {

		if i < j {
			swap2(nums, n-k-i, n-k+j-i, i)
			j -= i
		} else {
			swap2(nums, n-k-i, n-k, j)
			i -= j
		}
	}
	swap2(nums, n-k-i, n-k, i)
}

func swap2(nums []int, i, j, iter int) {
	for count := 0; count < iter; count++ {
		memo := nums[i+count]
		nums[i+count] = nums[j+count]
		nums[j+count] = memo
	}
}

// Juggling Swap
func rotate3(nums []int, k int) {

	n := len(nums)
	k %= n

	if k == 0 {
		return
	}

	gcd := gcd(n, k)

	for i := 0; i < gcd; i++ {
		temp := nums[i]

		j := i

		for {
			z := (j - k + n) % n
			if z == i {
				break
			}
			nums[j] = nums[z]
			j = z
		}
		nums[j] = temp
	}
}

func gcd(i, j int) int {

	for i%j != 0 {
		rem := i % j
		i = j
		j = rem
	}
	return j
}
