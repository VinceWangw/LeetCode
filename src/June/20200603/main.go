package main

import "fmt"

func main() {
	nums := []int{0, 1, 0, 1}
	fmt.Println(findMaxLength(nums))
}

func findMaxLength(nums []int) int {
	mp := map[int]int{}
	zeros, ones := 0, 0
	res := 0
	mp[0] = -1
	for i, num := range nums {
		if num == 0 {
			zeros++
		} else {
			ones++
		}
		k := zeros - ones
		if v, ok := mp[k]; ok {
			if i-v > res {
				res = i - v
			}
		} else {
			mp[k] = i
		}
	}

	return res
}
