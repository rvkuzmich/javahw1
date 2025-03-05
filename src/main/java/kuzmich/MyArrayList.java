package kuzmich;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Реализация ArrayList с динамическим размером. Содержит методы добавления, удаления, замены элемента,
 * очистки листа и сортировки.
 *
 * @param <E> тип элементов в листе
 */
public class MyArrayList<E> {
    private E[] list;
    private int tailIndex;
    private static final int DEFAULT_SIZE = 10;

    /**
     * Конструктор по умолчанию, создает список из 10 элементов
     */
    public MyArrayList() {
        list = (E[]) new Object[DEFAULT_SIZE];
        tailIndex = 0;
    }

    /**
     * Конструктор, создающий список указанного размера
     *
     * @param size размер списка
     */
    public MyArrayList(int size) {
        list = (E[]) new Object[size];
        tailIndex = 0;
    }

    /**
     * Метод добавления элемента в список
     *
     * @param element элемент для добавления в список
     */
    public void add(E element) {
        if (tailIndex >= list.length) {
            E[] temp = (E[]) new Object[list.length / 2 + list.length + 1];
            for (int i = 0; i < list.length; i++) {
                temp[i] = list[i];
            }
            list = temp;
        }
        list[tailIndex++] = element;
    }

    /**
     * Метод добавления элемента в список по указанному индексу
     *
     * @param index   индекс, по которому добавляется элемент
     * @param element элемент для добавления в список
     */
    public void add(int index, E element) {
        if (tailIndex >= list.length) {
            E[] temp = (E[]) new Object[list.length / 2 + list.length + 1];
            for (int i = 0; i < list.length; i++) {
                temp[i] = list[i];
            }
            list = temp;
        }
        if (index < 0 || index >= list.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = tailIndex - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = element;
        tailIndex++;
    }

    /**
     * Метод получения элемента из списка по индексу
     *
     * @param index индекс, по которому нужно получить элемент
     * @return элемент с указанным индексом
     */
    public E get(int index) {
        if (index < 0 || index >= list.length) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    /**
     * Метод удаления элемента из списка
     *
     * @param element элемент для удаления из списка
     */
    public void remove(E element) {
        int index = -1;
        for (int i = 0; i < tailIndex - 1; i++) {
            if (element.equals(list[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new NoSuchElementException();
        }
        for (int i = index; i < tailIndex - 1; i++) {
            list[i] = list[i + 1];
        }
        tailIndex--;
    }

    /**
     * Метод для удаления элемента по указанному индексу
     *
     * @param index индекс, по которому нужно удалить элемент
     * @return удаляемый элемент
     */
    public E remove(int index) {
        if (index < 0 || index >= list.length) {
            throw new IndexOutOfBoundsException();
        }
        E temp = list[index];
        for (int i = index; i < tailIndex - 1; i++) {
            list[i] = list[i + 1];
        }
        tailIndex--;
        return temp;
    }

    /**
     * Метод полной очистки списка
     */
    public void clear() {
        list = (E[]) new Object[list.length];
        tailIndex = 0;
    }

    /**
     * Метод замены элемента по указанному индексу
     *
     * @param index   индекс, по которому нужно заменить элемент
     * @param element новый элемент, который нужно поместить по указанному индексу
     */
    public void changeElement(int index, E element) {
        if (index < 0 || index >= list.length) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = element;
    }

    /**
     * Метод получения текущего размера списка
     *
     * @return текущий размер списка
     */
    public int size() {
        return list.length;
    }

    /**
     * Метод получения индекса последнего ненулевого элемента списка
     *
     * @return индекс последнего ненулевого элемента списка
     */
    public int lastNotNullElementIndex() {
        return tailIndex - 1;
    }

    /**
     * Метод быстрой сортировки списка, в качестве опорного элемента принимается средний элемент
     *
     * @param comparator компаратор для сравнения элементов списка
     * @param low        индекс первого элемента
     * @param high       индекс последнего элемента
     */
    public void quicksort(Comparator<E> comparator, int low, int high) {
        if (list.length == 0) return;
        if (low >= high) return;

        int middle = low + (high - low) / 2;
        int i = low;
        int j = high;
        E pivot = list[middle];

        while (i <= j) {
            while (comparator.compare(list[i], pivot) < 0) {
                i++;
            }
            while (comparator.compare(list[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                E temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) quicksort(comparator, low, j);
        if (high > i) quicksort(comparator, i, high);
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}
