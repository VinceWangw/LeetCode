package days.day18.常数时间插入删除和获取随机元素;

/**
 * 类名: Main
 * 描述: TODO
 * 姓名: 悟天
 * 日期: 2020-12-31 11:20
 **/
public class Main {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj);
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        System.out.println(obj);
        obj.remove(2);
        System.out.println(obj);
        obj.remove(3);
        System.out.println(obj);
        int param3 = obj.getRandom();
        System.out.println(param3);
    }

}
