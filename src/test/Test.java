package test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

//        Integer[] Array = {1, 2, 3};
//        int[] array = {1, 2, 3};
//
//        List List = Arrays.asList(Array);
//        List list = Arrays.asList(array);
//
//        System.out.println(List.size());
//        System.out.println(list.size());

        Integer [] myArray = { 1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println(list);
        

        System.out.println(list);



    }
}

class Pair<T>{
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" + "value=" + value + '}';
    }
}

class DataInter extends Pair<Date>{

    @Override
    public Date getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }
}
