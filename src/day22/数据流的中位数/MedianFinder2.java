package day22.数据流的中位数;


import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * */
class MedianFinder2 {

    private PriorityQueue<Integer> min ;
    private PriorityQueue<Integer> max ;

    /** initialize your data structure here. */
    public MedianFinder2() {
        min = new PriorityQueue<>((o1, o2) -> o2 - o1);
        max = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

    }
    
    public double findMedian() {

    }

    public static void main(String[] args) {
        MedianFinder2 m = new MedianFinder2();
        for (int i = -1; i > -4; i--) {
            m.addNum(i);
            System.out.println(m.findMedian());
        }
        System.out.println(m.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */