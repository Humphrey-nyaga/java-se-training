package com.systechafrica.part3.generics;

public class Storage<T> {
    public void store(T[] items){
        for (T item: items) {
            System.out.println(item);
        }
    }
    public T store(T t){
        return t;
    }
}
