package WordPattern

import "testing"

func TestWordPattern(t *testing.T) {

	var testData = []struct {
		inputPattern   string
		inputString    string
		expectedResult bool
	}{
		{
			inputPattern:   "abba",
			inputString:    "dog cat cat dog",
			expectedResult: true,
		},
		{
			inputPattern:   "abba",
			inputString:    "dog cat cat fish",
			expectedResult: false},
		{
			inputPattern:   "aaaa",
			inputString:    "dog cat cat dog",
			expectedResult: false,
		},
	}

	for i, data := range testData {
		res := wordPattern(data.inputPattern, data.inputString)
		if res != data.expectedResult {
			t.Errorf("Test %d has failed, expected: %t, got: %t", i+1, data.expectedResult, res)
		}
	}
}
