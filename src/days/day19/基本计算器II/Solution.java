package days.day19.基本计算器II;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 */
class Solution {

    public int calculate(String s) {

        s = s.replace(" ", "");

        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ) {

            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                stack.push(String.valueOf(num));
            } else if (s.charAt(i) == '+') {
                stack.push("+");
                i++;
            } else if (s.charAt(i) == '-') {
                stack.push("+");
                i++;
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                stack.push(Integer.toString(-num));
            } else if (s.charAt(i) == '*') {
                int a = Integer.parseInt(stack.pop());
                i++;
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                stack.push(String.valueOf(a * num));
            } else if (s.charAt(i) == '/') {
                int a = Integer.parseInt(stack.pop());
                i++;
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if (num == 0) {
                    throw new IllegalArgumentException("除数不能为0");
                }
                int r = a / num;
                stack.push(String.valueOf(r));
            }
        }

        while (stack.size() > 1) {
            int a = Integer.parseInt(stack.pop());
            char c = stack.poll().charAt(0);
            int b = Integer.parseInt(stack.pop());
            if (c == '+') {
                stack.push(String.valueOf(a + b));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public int calculate2(String s) {

        Deque<Integer> stack = new ArrayDeque<>();
        s = s.replace(" ", "");
        int n = s.length();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c >= '0') {
                num = num * 10 - '0' + c;
            }
            if (c < '0' || i == n-1){
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*' || sign == '/') {
                    int tmp = sign == '*' ? stack.pop() * num : stack.pop() / num;
                    stack.push(tmp);
                }
                sign = c;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }


    public static void main(String[] args) {
//        System.out.println(new Solution().calculate("1-1+1"));
//        System.out.println(new Solution().calculate("3+5 / 2"));
//        System.out.println(new Solution().calculate("3 + 6"));
//        System.out.println(new Solution().calculate("5/2"));
//        System.out.println(new Solution().calculate("3+ 5/2* 2-2"));
//        System.out.println(new Solution().calculate("2-1"));
//        System.out.println(new Solution().calculate("42"));
//        System.out.println(new Solution().calculate("1*2-3/4+5*6-7*8+9/10"));

//        System.out.println(new Solution().calculate2("1-1+1"));
//        System.out.println(new Solution().calculate2("3+5 / 2"));
//        System.out.println(new Solution().calculate2("3 + 6"));
//        System.out.println(new Solution().calculate2("5/2"));
        System.out.println(new Solution().calculate2("3+ 5/2* 2-2"));
        System.out.println(new Solution().calculate2("2-1"));
        System.out.println(new Solution().calculate2("42"));
        System.out.println(new Solution().calculate2("1*2-3/4+5*6-7*8+9/10"));
    }
}