package IteratorsAndComparators9.IteratorsAndComparatorsListyIteratorEx02;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> data; //списък с данни за обхождане
    private int index; // текущ индекс

    public ListyIterator(List<String> data) {
        this.data = data;
        if (this.data.size() != 0) {
            this.index = 0;
        } else {
            this.index = -1;
        }
    }

    //•	Move - should move an internal index position to the next index in the list,
// the method should return true if it successfully moved and false if there is no next index.
    public boolean move() {
        if (this.index < this.data.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    //should return true if there is a next index and false if the
// index is already at the last element of the list.
    public boolean HasNext() {
        return this.index < this.data.size() - 1;
    }

    public void print() throws Exception {
        if (!this.data.isEmpty()) {
            System.out.println(this.data.get(this.index));
        } else {
            System.out.println("Invalid Operation!");
        }
    }

    //        printAll
    public void printAll() {
        for (String string : this.data) {
            System.out.print(string + " ");
        }
        System.out.println();

    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < data.size() - 1;
            }

            @Override
            public String next() {
                return data.get(this.index++);
            }
        };
    }
}

