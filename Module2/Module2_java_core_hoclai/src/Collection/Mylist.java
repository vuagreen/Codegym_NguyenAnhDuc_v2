package Collection;

import java.util.Arrays;

public class Mylist<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public Mylist() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
}
