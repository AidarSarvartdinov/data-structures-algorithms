package com.aidar.ds.LinkedList;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {
    private LinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new LinkedList<>();
    }
    
    @Test
    public void addElements() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(list.get(0).intValue(), 1);
        assertEquals(list.get(1).intValue(), 2);
        assertEquals(list.get(2).intValue(), 3);
        assertEquals(list.size(), 3);
    }

    @Test
    public void removeElements() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1);
        assertEquals(list.size(), 2);
        assertEquals(list.get(1).intValue(), 3);
        assertThrows(NullPointerException.class, () -> list.get(2));

        list.remove(0);
        assertEquals(list.get(0).intValue(), 3);
    }

    @Test
    public void removeTheOnlyElement() {
        list.add(1);
        list.remove(0);
        assertEquals(list.size(), 0);
        assertThrows(NullPointerException.class, () -> list.get(0));
    }

    @Test
    public void setElements() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.set(10, 1);
        assertEquals(list.get(1).intValue(), 10);

        list.set(15, 0);
        assertEquals(list.get(0).intValue(), 15);

        list.set(20, 2);
        assertEquals(list.get(2).intValue(), 20);
    }

    @Test
    public void addAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.addAtIndex(10, 1);
        assertEquals(list.get(1).intValue(), 10);
        assertEquals(list.get(2).intValue(), 2);

        list.addAtIndex(5, 0);
        assertEquals(list.get(0).intValue(), 5);
        assertEquals(list.get(1).intValue(), 1);
        assertEquals(list.get(4).intValue(), 3);
    }

}
