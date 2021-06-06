package main

import (
	"fmt"
	"strings"
)

//strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3

func main() {
	strs := []string{"10", "0001", "111001", "1", "0"}
	m, n := 5, 3
	fmt.Println(findMaxForm(strs, m, n))
}

func findMaxForm(strs []string, m int, n int) int {
	dp := make([][]int, m+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
	}
	for _, str := range strs {
		zeros := strings.Count(str, "0")
		ones := len(str) - zeros
		for j := m; j > zeros; j-- {
			for k := n; k > ones; k-- {
				dp[j][k] = max(1+dp[j-zeros][k-ones], dp[j][k])
			}
		}
	}
	return dp[m][n]
}

func max(i, j int) int {
	if i > j {
		return i
	} else {
		return j
	}
}
