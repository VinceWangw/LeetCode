package main

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	a, b := headA, headB
	f := func(node, another *ListNode) *ListNode {
		if node != nil {
			return node.Next
		}
		return another
	}
	for a != b {
		a = f(a, headB)
		b = f(b, headA)
	}
	return a
}
