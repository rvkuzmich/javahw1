package kuzmich;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.NoSuchElementException;

class MyArrayListTest {

    @Test
    void lastNotNullElementIndexTest() {
        MyArrayList<Integer> list1 = new MyArrayList<>(3);
        list1.add(1);
        list1.add(2);
        list1.add(3);

        int expectedLastNotNullElementIndex = 2;
        int actualLastNotNullElementIndex = list1.lastNotNullElementIndex();

        Assertions.assertEquals(expectedLastNotNullElementIndex, actualLastNotNullElementIndex);
    }

    @Test
    void addTest() {
        MyArrayList<Integer> list1 = new MyArrayList<>(5);

        for (int i = 1; i <= 1000; i++) {
            list1.add(i);
        }

        int expected1 = 1;
        int expected2 = 2;
        int expected3 = 3;
        int expected4 = 4;
        int expected5 = 5;
        int expectedLastNotNullElementIndex = 999;

        Assertions.assertEquals(expected1, list1.get(0));
        Assertions.assertEquals(expected2, list1.get(1));
        Assertions.assertEquals(expected3, list1.get(2));
        Assertions.assertEquals(expected4, list1.get(3));
        Assertions.assertEquals(expected5, list1.get(4));
        Assertions.assertEquals(expectedLastNotNullElementIndex, list1.lastNotNullElementIndex());

        int expectedSize = 1232;

        Assertions.assertEquals(expectedSize, list1.size());

    }

    @Test
    void insertIntoIndexTest() {
        MyArrayList<Integer> list1 = new MyArrayList<>(5);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(2, 5);

        int expected1 = 1;
        int expected2 = 2;
        int expected3 = 5;
        int expected4 = 3;
        int expected5 = 4;
        int expectedLastNotNullElementIndex = 4;

        Assertions.assertEquals(expected1, list1.get(0));
        Assertions.assertEquals(expected2, list1.get(1));
        Assertions.assertEquals(expected3, list1.get(2));
        Assertions.assertEquals(expected4, list1.get(3));
        Assertions.assertEquals(expected5, list1.get(4));
        Assertions.assertEquals(expectedLastNotNullElementIndex, list1.lastNotNullElementIndex());
    }

    @Test
    void getElementTest() {
        MyArrayList<Integer> list1 = new MyArrayList<>(5);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        int expected = 3;
        int actual = list1.get(2);

        Assertions.assertEquals(expected, actual);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list1.get(10);
        });
    }

    @Test
    void removeTest() {
        MyArrayList<Integer> list1 = new MyArrayList<>(5);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        Integer elem = 3;

        list1.remove(elem);

        int expected = 4;
        int actual = list1.get(2);

        Assertions.assertEquals(expected, actual);

        Integer element2 = 50;
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            list1.remove(element2);
        });
    }

    @Test
    void removeByIndexTest() {
        MyArrayList<Integer> list1 = new MyArrayList<>(5);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list1.remove(10);
        });

        for (int i = 1; i <= 1000; i++) {
            list1.add(i);
        }
        int expected = 1000;
        for (int i = 999; i >= 0; i--) {
            int actual = list1.remove(i);
            Assertions.assertEquals(expected--, actual);
        }
    }

    @Test
    void clearTest() {
        MyArrayList<Integer> list1 = new MyArrayList<>(5);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list1.clear();

        int expectedLastNotNullElementIndex = -1;
        int actualLastNotnullElementIndex = list1.lastNotNullElementIndex();

        Integer actual1 = list1.get(0);
        Integer actual2 = list1.get(1);
        Integer actual3 = list1.get(2);
        Integer actual4 = list1.get(3);
        Integer actual5 = list1.get(4);

        Assertions.assertEquals(expectedLastNotNullElementIndex, actualLastNotnullElementIndex);
        Assertions.assertNull(actual1);
        Assertions.assertNull(actual2);
        Assertions.assertNull(actual3);
        Assertions.assertNull(actual4);
        Assertions.assertNull(actual5);
    }

    @Test
    void changeElementTest() {
        MyArrayList<Integer> list1 = new MyArrayList<>(5);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list1.changeElement(0, 6);

        int expected = 6;
        int actual = list1.get(0);

        Assertions.assertEquals(expected, actual);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list1.changeElement(8, 6);
        });
    }


    @Test
    void quicksortTest() {
        MyArrayList<Integer> list1 = new MyArrayList<>(5);
        list1.add(4);
        list1.add(3);
        list1.add(1);
        list1.add(5);
        list1.add(2);

        list1.quicksort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }, 0, list1.lastNotNullElementIndex());

        int expected1 = 1;
        int expected2 = 2;
        int expected3 = 3;
        int expected4 = 4;
        int expected5 = 5;

        int actual1 = list1.get(0);
        int actual2 = list1.get(1);
        int actual3 = list1.get(2);
        int actual4 = list1.get(3);
        int actual5 = list1.get(4);

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);
        Assertions.assertEquals(expected4, actual4);
        Assertions.assertEquals(expected5, actual5);
    }
}