package com.paul.jvm;

import java.util.*;

public class AbstractSetTest {

    public static void main(String[] args) {
        List<Long> arrays = new ArrayList<>();
        arrays.add(1L);
        arrays.add(2L);
        arrays.add(3L);
        MySet<Long> set = new MySet<>(arrays.iterator());
        System.out.println(set);
        System.out.println(set);

        set.setIter(arrays.iterator());
        System.out.println(set);
    }

    static class MySet<T> extends AbstractSet<T> {

        public Iterator<T> iter;

        public MySet(Iterator<T> iterator) {
            this.iter = iterator;
        }

        @Override
        public Iterator<T> iterator() {
            return iter;
        }

        @Override
        public int size() {
            return 0;
        }

        public Iterator<T> getIter() {
            return iter;
        }

        public void setIter(Iterator<T> iter) {
            this.iter = iter;
        }
    }
}
