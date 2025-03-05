package kuzmich;

import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> integers = new MyArrayList<>(10);

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(100));
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

        MyArrayList<String> strings = new MyArrayList<>(5);

        strings.add("Яна");
        strings.add("Вася");
        strings.add("Java");
        strings.add("Роман");
        strings.add("Николай");

        System.out.println(strings);

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        strings.quicksort(stringComparator, 0, strings.lastNotNullElementIndex());

        System.out.println(strings);
    }
}
