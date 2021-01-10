package days.day22.最小栈;

import java.util.Stack;

/**
 * 类名: MinStack2
 * 描述: TODO
 * 姓名: 悟天
 * 日期: 2021-01-04 16:49
 **/
class MinStack2 {

    private Stack<Integer> data;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack2() {

        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {

        data.push(x);
        if (min.isEmpty() || x <= min.peek()){
            min.push(x);
        }

    }

    public void pop() {

        data.pop();
        while (data.isEmpty() || !data.contains(min.peek())){
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    @Override
    public String toString() {
        return "MinStack2{" +
                "data=" + data +
                ", min=" + min +
                '}';
    }

    public static void main(String[] args) {
        MinStack2 ms = new MinStack2();

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
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */