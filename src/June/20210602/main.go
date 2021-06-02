package main

import "fmt"

func main() {
	nums, k := []int{1, 0}, 2
	fmt.Println(get(checkSubarraySum, nums, k), get(checkSubarraySum2, nums, k))

	nums, k = []int{23, 2, 4, 6, 6}, 7
	fmt.Println(get(checkSubarraySum, nums, k), get(checkSubarraySum2, nums, k))

	nums, k = []int{0, 0}, 7
	fmt.Println(get(checkSubarraySum, nums, k), get(checkSubarraySum2, nums, k))

}

func checkSubarraySum(nums []int, k int) bool {
	n := len(nums)
	if n < 2 {
		return false
	}
	sum := make([]int, n+1)
	sum[0] = nums[0]
	for i := 1; i <= n; i++ {
		sum[i] = sum[i-1] + nums[i-1]
	}
	contains := map[int]bool{}
	for i := 2; i <= n; i++ {
		contains[sum[i-2]%k] = true
		if contains[sum[i]%k] {
			return true
		}
	}
	return false
}

func checkSubarraySum2(nums []int, k int) bool {
	n := len(nums)
	if n < 2 {
		return false
	}
	sum := 0
	mp := map[int]int{0: -1}
	for i, num := range nums {
		sum += num
		mod := sum % k
		if v, ok := mp[mod]; ok {
			if i-v >= 2 {
				return true
			}
		} else {
			mp[mod] = i
		}
	}
	return false
}

func get(f func(nums []int, k int) bool, nums []int, k int) bool {
	return f(nums, k)
}
