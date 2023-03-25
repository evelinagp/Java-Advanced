package Generics8.Ex.GenericCustomListEx07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public List<T> getValues() {
        return this.values;
    }

    public void add(T element) {
        this.values.add(element);
    }

    public T remove(int index) {
//        validateIndexes(index);
        return this.values.remove(index);
    }


    public boolean contains(T element) {
        return this.values.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
//        validateIndexes(firstIndex);
//        validateIndexes(secondIndex);
//        Collections.swap(this.values, firstIndex, secondIndex);
//        Втори вариант!
        T firstElement = this.values.get(firstIndex);
        T secondElement = this.values.get(secondIndex);

        this.values.set(firstIndex, secondElement);
        this.values.set(secondIndex, firstElement);

//        Трети вариант
//        this.elements.add(firstIndex, secondElement);
//        this.elements.remove(firstIndex + 1);
//        this.elements.add(secondIndex, firstElement);
//        this.elements.remove(secondIndex + 1);
    }

    private void validateIndexes(int index) {
        if (index < 0 || index >= this.values.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public int countGreaterThan(T element) {
        return (int) this.values.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMin() {
//        return Collections.max(this.values);
//        if (this.values.isEmpty()) {
//            throw new IllegalStateException("Empty list!!!");
//        }
//        T min = this.values.get(0);
//        for (int i = 1; i < this.values.size(); i++) {
//            T current = this.values.get(i);
//            if (current.compareTo(min) < 0) {
//                min = current;
//            }
//        }
//        return min;
        return this.values.stream().min(Comparable::compareTo).get();
    }

    public T getMax() {
//        return Collections.max(this.values);
//        if (this.values.isEmpty()) {
//            throw new IllegalStateException("Empty list!!!");
//        }
//        T max = this.values.get(0);
//        for (int i = 1; i < this.values.size(); i++) {
//            T current = this.values.get(i);
//            if (current.compareTo(max) > 0) {
//                max = current;
//            }
//        }
//        return max;
        return this.values.stream().max(Comparable::compareTo).get();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < values.size();
            }

            @Override
            public T next() {
                return values.get(index++);
            }
        };
    }
}
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        for (T element : this.values) {
//            sb.append(element).append(System.lineSeparator());
//        }
//        return sb.toString();
//    }
//
//    public int size() {
//        return this.values.size();
//    }
//
//    public T get(int index) {
//        return this.values.get(index);
//    }

