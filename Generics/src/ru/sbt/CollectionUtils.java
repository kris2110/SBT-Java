package ru.sbt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList(Collection< ? extends T> source) {
        List<T> list = new ArrayList();
        list.addAll(source);
        return list;
    }

    public static<T> int indexOf(List<? super T> source, Object o) {
        return source.indexOf(o);
    }

    public static<T> List limit(List<? > source, int size) {
        return source.subList(0, size);
    }

    public static<T> void add(List<? super T> destination, T o) {
        destination.add(o);
    }

    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.remove(c2);
    }

    public static<T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static<T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        return c1.contains(c2);
    }

    public static<T> List range(List<? extends T> list, Object min, Object max) {
        return range(list, min, max, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 1;
            }
        });

    }

    public static<T> List range(List list, Object min, Object max, Comparator comparator) {
        return null;
    }

}