package BestTimeToBuyAndSellStockII

func maxProfit(prices []int) int {

	maxProfit, minPrice := 0, prices[0]

	for i := 0; i < len(prices); i++ {

		if prices[i] < minPrice {
			minPrice = prices[i]
		}

		currProfit := prices[i] - minPrice

		if currProfit > 0 {
			maxProfit += currProfit
			minPrice = prices[i]
		}

	}

	return maxProfit
}

func maxProfit2(prices []int) int {

	maxProfit := 0

	for i := 1; i < len(prices); i++ {

		if prices[i]-prices[i-1] > 0 {
			maxProfit += prices[i] - prices[i-1]
		}

	}

	return maxProfit
}
