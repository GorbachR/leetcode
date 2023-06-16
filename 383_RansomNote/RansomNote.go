package RansomNote

func canConstruct(ransomNote string, magazine string) bool {
	memo := map[byte]int{}

	for i := 0; i < len(magazine); i++ {
		memo[magazine[i]]++
	}

	for i := 0; i < len(ransomNote); i++ {
		if memo[ransomNote[i]] <= 0 {
			return false
		}
		memo[ransomNote[i]]--
	}

	return true
}
