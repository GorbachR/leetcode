package WordPattern

import "strings"

func wordPattern(pattern string, s string) bool {

	wordToPattern := map[string]byte{}
	patternToWord := map[byte]string{}
	words := strings.Split(s, " ")

	if len(words) != len(pattern) {
		return false
	}

	for pos, word := range words {

		if storedPattern, patternExists := wordToPattern[word]; patternExists && storedPattern != pattern[pos] {
			return false
		}

		if storedWord, wordExists := patternToWord[pattern[pos]]; wordExists && storedWord != word {
			return false
		}

		patternToWord[pattern[pos]] = word
		wordToPattern[word] = pattern[pos]
	}

	return true
}
