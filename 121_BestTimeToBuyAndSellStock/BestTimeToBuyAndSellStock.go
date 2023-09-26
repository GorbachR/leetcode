package BestTimeToBuyAndSellStock

import "math"

func maxProfit(prices []int) int {

	profit, minPrice := 0, math.MaxInt64

	for i := 0; i < len(prices); i++ {
		if minPrice > prices[i] {
			minPrice = prices[i]
		}

		currProfit := prices[i] - minPrice

		if currProfit > profit {
			profit = currProfit
		}
	}

	return profit
}
