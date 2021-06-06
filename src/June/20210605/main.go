package main

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6 -> nil
// 6

func removeElements(head *ListNode, val int) *ListNode {
	dummy := &ListNode{-1, head}
	dummyHead := dummy
	for dummyHead.Next != nil {
		if dummyHead.Next.Val == val {
			del := dummyHead.Next
			dummyHead.Next = del.Next
			del.Next = nil
		}
		if dummyHead.Next != nil && dummyHead.Next.Val != val {
			dummyHead = dummyHead.Next
		}
	}
	return dummy.Next
}
