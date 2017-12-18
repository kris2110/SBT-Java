package ru.sbt;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CountMapImplTest {
    CountMap<Integer> map = new CountMapImpl<>();


    @Test
    public void add() throws Exception {
        map.add(1);
        map.add(2);
        map.add(2);
        map.add(4);
        map.add(4);
        map.add(4);
        map.add(4);
    }

    @Test
    public void getCount() throws Exception {
        add();
        assertEquals(1, map.getCount(1));
        assertEquals(2, map.getCount(2));
        assertEquals(4, map.getCount(4));
    }

    @Test
    public void remove() throws Exception {
        add();
        assertEquals(1, map.remove(1));
        assertEquals(2, map.remove(2));
        assertEquals(4, map.remove(4));
        assertEquals(0, map.remove(128));
    }

    @Test
    public void size() throws Exception {
        add();
        assertEquals(3, map.size());
    }

    @Test
    public void addAll() throws Exception {
        add();
        CountMap<Integer> secondMap = new CountMapImpl<>();
        secondMap.add(1);
        secondMap.add(512);
        map.addAll(secondMap);
        assertEquals(2, map.getCount(1));
        assertEquals(1, map.getCount(512));
    }

    @Test
    public void toMap() throws Exception {
        add();
        Map<Integer, Integer> mapMap = map.toMap();
        assertEquals(new Integer(1), mapMap.get(1));
        assertEquals(new Integer(2), mapMap.get(2));
        assertEquals(new Integer(4), mapMap.get(4));
    }

    @Test
    public void toMap1() throws Exception {
        add();
        Map<Integer, Integer> mapMap = new HashMap<>();
        map.toMap(mapMap);
        assertEquals(new Integer(1), mapMap.get(1));
        assertEquals(new Integer(2), mapMap.get(2));
        assertEquals(new Integer(4), mapMap.get(4));
    }


}