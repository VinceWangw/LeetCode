package day22.数据流的中位数;


import java.util.Arrays;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * */
class MedianFinder {

    int capacity;
    int size;
    int[] nums;

    /** initialize your data structure here. */
    public MedianFinder() {
        capacity = 50;
        nums = new int[capacity];
        size = 0;
    }
    
    public void addNum(int num) {
        if (size == capacity){
            reSize();
        }
        nums[size++] = num;
        Arrays.sort(nums,0,size);
        System.out.println(Arrays.toString(nums));
    }
    
    public double findMedian() {
        if (size % 2 == 0){
            return ((double) nums[(size/2) - 1] + (double)nums[size/2])/2;
        }else {
            return nums[(size /2 )];
        }
    }

    private void reSize(){
        int newCapacity = (int)(capacity * 1.5);
        int[] newNums = new int[newCapacity];
        for (int i = 0; i < capacity; i ++){
            newNums[i] = nums[i];
        }
        nums = newNums;
        capacity = newCapacity;

    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
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