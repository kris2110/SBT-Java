package ru.sbt;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T element) {
        if (this.map.containsKey(element)){
            this.map.put(element, 1 + this.map.get(element));
        }
        else{
            this.map.put(element, 1);
        }
        return;
    }


    @Override
    public int getCount(T element) {
        if (this.map.containsKey(element)){
            return this.map.get(element);
        }
        return 0;
    }

    @Override
    public int remove(T element) {
        if (this.map.containsKey(element)){
            int numberOfDeletedElements = this.map.get(element);
            this.map.remove(element);
            return numberOfDeletedElements;
        }
        return 0;
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source){
        Map<T, Integer> src = source.toMap();
        for (Map.Entry<T, Integer> entry: src.entrySet()){
            if (this.map.containsKey(entry.getKey())){
                this.map.put(entry.getKey(), entry.getValue() + this.map.get(entry.getKey()));
            }else {
                this.map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public Map toMap() {
        Map<T, Integer> m = (new HashMap<>());
        m.putAll(this.map);
        return m;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.clear();
        destination.putAll(this.map);
    }
}