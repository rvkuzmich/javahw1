package kuzmich;

import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> integers = new MyArrayList<>(10);

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt( 100));
        }

        System.out.println(integers);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        integers.quicksort(comparator, 0, integers.lastNotNullElementIndex());
        System.out.println(integers);
    }
}
