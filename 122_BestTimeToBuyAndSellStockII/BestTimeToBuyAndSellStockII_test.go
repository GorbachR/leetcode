package BestTimeToBuyAndSellStockII

import "testing"

func TestMaxProfit(t *testing.T) {
	prices1 := []int{7, 1, 5, 3, 6, 4}

	result1, expected1 := maxProfit(prices1), 7

	if result1 != expected1 {
		t.Errorf("Test 1 failed, expected %d but got %d", expected1, result1)
	}

	prices2 := []int{1, 2, 3, 4, 5}

	result2, expected2 := maxProfit(prices2), 4

	if result2 != expected2 {
		t.Errorf("Test 2 failed, expected %d but got %d", expected2, result2)
	}

	prices3 := []int{7, 6, 4, 3, 1}

	result3, expected3 := maxProfit(prices3), 0

	if result3 != expected3 {
		t.Errorf("Test 3 failed, expected %d but got %d", expected3, result3)
	}

}
