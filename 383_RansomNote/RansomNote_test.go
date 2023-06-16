package RansomNote

import "testing"

func TestCanConstruct(t *testing.T) {
	ransomNote1, magazine1 := "a", "b"

	result1, expected1 := canConstruct(ransomNote1, magazine1), false

	if result1 != expected1 {
		t.Errorf("Expected %t but got %t", expected1, result1)
	}

	ransomNote2, magazine2 := "aa", "ab"

	result2, expected2 := canConstruct(ransomNote2, magazine2), false

	if result2 != expected2 {
		t.Errorf("Expected %t but got %t", expected2, result2)
	}

	ransomNote3, magazine3 := "aa", "aab"

	result3, expected3 := canConstruct(ransomNote3, magazine3), true

	if result3 != expected3 {
		t.Errorf("Expected %t but got %t", expected3, result3)
	}
}
