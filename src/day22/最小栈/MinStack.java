package day22.最小栈;

import java.util.*;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。 pop() —— 删除栈顶的元素。 top() —— 获取栈顶元素。 getMin() —— 检索栈中的最小元素。
 *
 */

class MinStack {

    LinkedList<Integer> stack;
    PriorityQueue<Integer> pq;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> stack.get(o)));
    }

    public void push(int x) {
        stack.addLast(x);
        pq.add(stack.indexOf(x));
    }

    public void pop() {
        int delId = stack.indexOf(stack.peekLast());
        stack.removeLast();
        pq.remove(delId);
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return stack.get(pq.peek());
    }

    @Override
    public String toString() {
        return "MinStack{" + stack + '}' + " min:" + this.getMin() + "  pq: " + pq;
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(100);
        ms.push(666);
        ms.push(2);
        ms.push(3);

        System.out.println(ms);
        ms.pop();
        System.out.println(ms);
        ms.push(100);
        System.out.println(ms);

        ms.pop();
        System.out.println(ms);
        ms.pop();
        System.out.println(ms);

    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack(); obj.push(x); obj.pop();
 * int param_3 = obj.top(); int param_4 = obj.getMin();
 */